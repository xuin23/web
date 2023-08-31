package com.cloud.frame.spring.common;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 方法计时功能
 *
 * @author xuin23
 * @since 20230830
 */
@Aspect
@Component
@Slf4j
public class TimingAop {

    public TimingAop() {
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
