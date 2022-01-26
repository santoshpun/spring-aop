package com.santosh.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExecutionTimeAspect {

    @Around("@annotation(com.santosh.springaop.annotations.ExecutionTime)")
    public Object timeTaken(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println(methodName + " method took " + executionTime + " ms to finish execution");
        return proceed;
    }
}
