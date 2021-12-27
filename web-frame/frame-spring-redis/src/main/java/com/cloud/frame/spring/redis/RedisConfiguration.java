package com.cloud.frame.spring.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis 配置
 *
 * @author xulijian
 */
@Slf4j
@Configuration
public class RedisConfiguration {

    /**
     * redisTemplate 配置
     *
     * @param factory factory
     * @return RedisTemplate
     * @author xulijian
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedissonConnectionFactory factory) {

        log.info("Redis Init");

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(
                new ObjectMapper()
                        .setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
                        .enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL));

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
