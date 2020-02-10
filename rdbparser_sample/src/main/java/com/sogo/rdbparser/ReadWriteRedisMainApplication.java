package com.sogo.rdbparser;

import com.sogo.rdbparser.proto.IdMappingProto;
import com.sogo.rdbparser.redis.RedisClusterBaseOps;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;


//@SpringBootApplication
public class ReadWriteRedisMainApplication implements CommandLineRunner
{
    @Autowired
    @Qualifier("idmapRedisTemplate")
    private RedisTemplate redisTemplate;

    private RedisClusterBaseOps redisClusterBaseOps = new RedisClusterBaseOps();


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ReadWriteRedisMainApplication.class);
        application.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        testRedisWithPb(args);
    }


    public void testRedisWithPb(String... args) throws Exception {
        long timeout = 3600;
        int cnt = 1000;
        while((cnt--) > 0 ) {
            String randomStr = RandomStringUtils.randomAlphabetic(32);
            String idvalue = "test_20200210_" + randomStr;

            IdMappingProto.IdBrief idBrief = IdMappingProto.IdBrief
                    .newBuilder()
                    .setType(IdMappingProto.IdType.AAID)
                    .setValue(idvalue)
                    .build();

            String redisKey = idvalue;
            byte[] redisValue = idBrief.toByteArray();
            int setRes = redisClusterBaseOps.set(redisTemplate, redisKey, redisValue, timeout);
            Object resRedisValue = redisClusterBaseOps.get(redisTemplate, redisKey);
            IdMappingProto.IdBrief resIdmap = IdMappingProto.IdBrief.parseFrom((byte[]) resRedisValue);
            if (null == resIdmap) {
                System.out.println("idvalue:" + idvalue + "; res:" + "empty");
                continue;
            }
            String resValue = resIdmap.getValue();

            System.out.println("idvalue:" + idvalue + "; res:" + resValue);

        }

    }

}
