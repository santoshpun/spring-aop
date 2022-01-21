package com.santosh.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CircleLoggingAspect {

    //logs all methods of Circle class
    @Before("execution(* com.santosh.springaop.service.Circle.*(..))")
    public void logAllmethods(JoinPoint joinPoint) {
        String targetClass = joinPoint.getTarget().getClass().getSimpleName();
        String targetMethod = joinPoint.getSignature().getName();
        System.out.println("AOP1[" + targetClass + " : " + targetMethod + "()] : " + joinPoint.getSignature().getName() + " is called");
    }

    //logs area method of Circle class
    @Before("execution(* com.santosh.springaop.service.Circle.area(..))")
    public void logArea(JoinPoint joinPoint) {
        String targetClass = joinPoint.getTarget().getClass().getSimpleName();
        String targetMethod = joinPoint.getSignature().getName();
        System.out.println("AOP2[" + targetClass + " : " + targetMethod + "()] : " + joinPoint.getSignature().getName() + " is called");
    }
}
