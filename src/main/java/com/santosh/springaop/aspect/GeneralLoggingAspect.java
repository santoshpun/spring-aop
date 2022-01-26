package com.santosh.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GeneralLoggingAspect {

    @Before("execution(public String getName())")
    public void getNameAdvice() {
        System.out.println("Executing Advice on getName()");
    }

    //logs all methods starting with get prefix for all classes inside service package
    @Before("execution(* com.santosh.springaop.service.*.get*())")
    public void getAllAdvice() {
        System.out.println("Service method getter called");
    }

    @Before("allMethodsPointcut()")
    public void allServiceMethodsAdvice(JoinPoint joinPoint) {
        System.out.println("== Before executing service method ====");
        String targetClass = joinPoint.getTarget().getClass().getSimpleName();
        String targetMethod = joinPoint.getSignature().getName();
        System.out.println("Invoked method : " + targetMethod + " of class : " + targetClass);
    }

    //Pointcut to execute on all the methods of classes in a service package
    @Pointcut("within(com.santosh.springaop.service.*)")
    public void allMethodsPointcut() {
    }

}
