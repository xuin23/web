package com.cloud.frame.spring.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * redis 配置
 *
 * @author xulijian
 */
@Slf4j
@Configuration
public class RedisConfiguration {


    @Resource
    ObjectMapper objectMapper;

    /**
     * Redis 模板 配置
     *
     * @param factory factory
     * @return {@link RedisTemplate}
     * @author xulijian
     */
    @Bean
    public RedisTemplate<String, ? extends Serializable> redisTemplate(RedissonConnectionFactory factory) {

        log.info("Redis Init");

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);

//        ObjectMapper objectMapper = new ObjectMapper()
//                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
//                //忽略 在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
//                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
//                //忽略空Bean转json的错误
//                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
//                //列出所有字段
//                .setSerializationInclusion(JsonInclude.Include.ALWAYS);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        return new RedisTemplate<>() {{

            setConnectionFactory(factory);

            setKeySerializer(stringRedisSerializer);
            setValueSerializer(jackson2JsonRedisSerializer);

            setHashKeySerializer(stringRedisSerializer);
            setHashValueSerializer(jackson2JsonRedisSerializer);

            afterPropertiesSet();
        }};
    }
}
