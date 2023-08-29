package com.cloud.frame.spring.common;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AopTiming {

    public AopTiming() {
        log.info("TimeAop Init");
    }

    @Pointcut("@annotation(com.cloud.frame.spring.common.Timing)")
    public void logPointCut() {

    }

    @Around(value = "logPointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;

        long l = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        log.info(methodSignature.getMethod().getDeclaringClass().getName() + "." + methodSignature.getMethod().getName() + " 用时" + (System.currentTimeMillis() - l));

        return proceed;

    }

}
