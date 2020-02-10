package com.sogo.rdbparser.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * redis 配置类
 * @author liuzhixuan
 *
 */

@Configuration
//启用缓存
@EnableCaching
@EnableAutoConfiguration
public class RedisClusterConf {
        
//    @Bean("redisTemplate")
//    @Primary
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        return redisTemplate;
//    }
//
//    /**
//     * StringRedisTemplate继承RedisTemplate, key/value均为String且默认采用的是String的序列化策略
//     * @param redisConnectionFactory:
//     * @return return
//     */
//    @Bean("stringRedisTemplate")
//    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        StringRedisTemplate strRedisTemplate = new StringRedisTemplate();
//        strRedisTemplate.setConnectionFactory(redisConnectionFactory);
//        return strRedisTemplate;
//    }

    @Autowired
    private Environment environment;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.redis.lettuce.pool")
    public GenericObjectPoolConfig redisPool() {
        return new GenericObjectPoolConfig();
    }

    /**
     * 配置idmapping的redis数据源
     * @return
     */
    @Bean("idmappingRedisClusterConfig")
    @Primary
    public RedisClusterConfiguration idmappingRedisClusterConfig() {
        Map<String, Object> conf = new HashMap<>();
        conf.put("spring.redis.cluster.nodes", environment.getProperty("spring.redis.cluster.nodes"));
        conf.put("spring.redis.timeout", environment.getProperty("spring.redis.timeout"));
        conf.put("spring.redis.cluster.max-redirects", environment.getProperty("spring.redis.cluster.max-redirects"));

        RedisClusterConfiguration redisClusterConfiguration =
                new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", conf));

        return redisClusterConfiguration;
    }

    /**
     * idmapping cluster 的连接工厂
     * @param redisPool
     * @param redisClusterConfig
     * @return
     */
    @Bean("idmappingLettuceConnectionFactory")
    @Primary
    public LettuceConnectionFactory idmappingLettuceConnectionFactory(GenericObjectPoolConfig redisPool,
        @Qualifier("idmappingRedisClusterConfig") RedisClusterConfiguration redisClusterConfig) {
        LettuceClientConfiguration clientConfiguration =
                LettucePoolingClientConfiguration.builder().poolConfig(redisPool).build();

        return new LettuceConnectionFactory(redisClusterConfig, clientConfiguration);
    }

    @Bean("idmapRedisTemplate")
    @Primary
    public RedisTemplate idmapRedisTemplate(
            @Qualifier("idmappingLettuceConnectionFactory") RedisConnectionFactory redisConnectionFactory) {
        return getRedisTemplate(redisConnectionFactory);
    }

    private RedisTemplate getRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson(jackson2JsonRedisSerializer)：反序列化 pb 时报错。因为pb带序列化，这里就不再序列化
        // Jackson2JsonRedisSerializer： 使用Jackson库将对象序列化为JSON字符串。
        // 优点是速度快，序列化后的字符串短小精悍，不需要实现Serializable接口。
        // 但缺点也非常致命，那就是此类的构造函数中有一个类型参数，必须提供要序列化对象的类型信息(.class对象)。
        // 通过查看源代码，发现其只在反序列化过程中用到了类型信息。
        //template.setValueSerializer(stringRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        return template;
    }

}

