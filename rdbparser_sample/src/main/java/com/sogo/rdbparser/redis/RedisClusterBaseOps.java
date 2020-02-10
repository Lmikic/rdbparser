package com.sogo.rdbparser.redis;

import io.netty.util.internal.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// @Component
public class RedisClusterBaseOps {

//    @Autowired
//    @Qualifier("idmapRedisTemplate")
//    private RedisTemplate redisTemplate;

    /**
     * 设置key、value、过期时间
     * @param redisTemplate 实例化后的redisTemplate对象
     * @param key key
     * @param value value
     * @param timeout，单位：秒
     * @return 0:success, other:fail
     */
    public int set(@NotNull RedisTemplate redisTemplate, String key, Object value, long timeout) {
        if (StringUtil.isNullOrEmpty(key) || StringUtils.isEmpty(value) || timeout < 0) {
            return -1;
        }
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
        return 0;
    }
    /**
     * 设置key、value，且key不过期时
     * @param redisTemplate 实例化后的redisTemplate对象
     * @param key key
     * @param value value
     * @return 0:success, other:fail
     */
    public int set(@NotNull RedisTemplate redisTemplate, String key, Object value) {
        if (StringUtil.isNullOrEmpty(key) || StringUtils.isEmpty(value)) {
            return -1;
        }
        redisTemplate.opsForValue().set(key, value);
        return 0;
    }

    /**
     * 设置一组key、value,且key不过期
     * @param redisTemplate 实例化后的redisTemplate对象
     * @param multiKeysAndValuesMap k-v map
     * @return 0:success, other:fail
     */
    public int multiSet(@NotNull RedisTemplate redisTemplate, Map<String,Object> multiKeysAndValuesMap) {
        redisTemplate.opsForValue().multiSet(multiKeysAndValuesMap);
        return 0;
    }

    /**
     * 设置一组key、value、过期时间
     * @param redisTemplate 实例化后的redisTemplate对象
     * @param multiKeysAndValuesMap k-v map
     * @return 返回成功插入redis中的数量
     */
    public int multiSet(@NotNull RedisTemplate redisTemplate, Map<String,Object> multiKeysAndValuesMap, long timeout) {
        int succNum = this.multiSet(redisTemplate, multiKeysAndValuesMap);

        for (String key : multiKeysAndValuesMap.keySet()) {
            // 设置过期时间失败时，succNum 减少1个
            if (!StringUtil.isNullOrEmpty(key) || !redisTemplate.expire(key, timeout, TimeUnit.SECONDS)) {
                succNum --;
            }
        }
        return succNum;
    }

    /**
     * 根据key获取value
     * @param redisTemplate 实例化后的redisTemplate对象
     * @param key key
     * @return 返回key对应的value
     */
    public Object get(@NotNull RedisTemplate redisTemplate, String key) {
        if (StringUtil.isNullOrEmpty(key)) {
            return null;
        }
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 根据一组key获取对应的value
     * @param redisTemplate 实例化后的redisTemplate对象
     * @param keys 一组key
     * @return 返回一组key对应的value
     */
    public List<Object> multiGet(@NotNull RedisTemplate redisTemplate, @NotNull List<String> keys) {
        return redisTemplate.opsForValue().multiGet(keys);
    }

    /**
     * 判断key是否存在
     * @param redisTemplate 实例化后的redisTemplate对象
     * @param key key
     * @return true: exists key, false: not exist key
     */
    public boolean hasKey(@NotNull RedisTemplate redisTemplate, final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除key
     * @param redisTemplate 实例化后的redisTemplate对象
     * @param key key
     * @return true: success to delete, false: fail to delete
     */
    public int delete(@NotNull RedisTemplate redisTemplate, String key) {
        if (StringUtil.isNullOrEmpty(key)) {
            return -1;
        } else {
            boolean res = redisTemplate.delete(key);
            if (res) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    /**
     * 删除key
     * @param redisTemplate 实例化后的redisTemplate对象
     * @param keys keys
     * @return 返回成功删除的key的个数
     */
    public Long delete(@NotNull RedisTemplate redisTemplate, @NotNull List<String> keys) {
        return redisTemplate.delete(keys);
    }

    /**
     * 获取key的过期时间
     * @param redisTemplate 实例化后的redisTemplate对象
     * @param key key
     * @return key剩余过期的秒数
     */
    public long getExipre(@NotNull RedisTemplate redisTemplate, String key) {
        if (!StringUtil.isNullOrEmpty(key)) {
            return redisTemplate.getExpire(key, TimeUnit.SECONDS);
        } else {
            return 0L;
        }
    }

    /**
     * 设置key的过期时间
     * @param redisTemplate 实例化后的redisTemplate对象
     * @param key key
     * @param timeout 过期时间，单位：秒
     * @return true: success; false: fail
     */
    public boolean setExipre(@NotNull RedisTemplate redisTemplate, String key, long timeout) {
        return redisTemplate.expire(key,timeout,TimeUnit.SECONDS);
    }
}
