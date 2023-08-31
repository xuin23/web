package com.cloud.frame.spring.redis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Redis锁 基于Redission
 *
 * @author xulijian
 * @since 20230831
 */
@Target(ElementType.METHOD)
public @interface RedisLock {
}
