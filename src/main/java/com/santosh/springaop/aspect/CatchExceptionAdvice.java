package com.santosh.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CatchExceptionAdvice {

    @Pointcut("execution(* com.santosh.springaop.manager.LoginManager.validate(..))")
    public void exceptionPointCut() {
    }

    @AfterThrowing(pointcut = "exceptionPointCut()", throwing = "ex")
    public void handleException(JoinPoint joinPoint, Throwable ex) {
        System.out.println("Method Signature : " + joinPoint.getSignature().getName());
        System.out.println("Exception caught : " + ex.getMessage());
    }
}
