package com.cloud.frame.spring.redis;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;


/**
 * Redis锁
 *
 * @author xuin23
 * @since 20230831
 */
@Slf4j
@Aspect
@Component
public class RedisLockAop {

    public RedisLockAop() {
        log.info("RedisLockAop Init");
    }

    @Resource
    RedissonClient redissonClient;

    @Pointcut("@annotation(com.cloud.frame.spring.redis.RedisLock)")
    public void pointCut() {

    }

    @Around(value = "pointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        Signature signature = joinPoint.getSignature();

        MethodSignature methodSignature = (MethodSignature) signature;

        String methodName = methodSignature.getMethod().getDeclaringClass().getName() + "." + methodSignature.getMethod().getName();

        RLock lock = redissonClient.getLock(methodName);

        lock.lock();

        log.info("Redis lock {}", methodName);
        try {
            return joinPoint.proceed();
        } finally {
            lock.unlock();
            log.info("Redis unlock {}", methodName);
        }

    }


}
