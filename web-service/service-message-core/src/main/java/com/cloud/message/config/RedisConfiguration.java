package com.cloud.message.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
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

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(new ObjectMapper().setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY));

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
