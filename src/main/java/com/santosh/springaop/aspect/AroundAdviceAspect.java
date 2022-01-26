package com.santosh.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAdviceAspect {

    //point cut for all classes and methods inside "com.santosh.springaop.manager" package
    @Pointcut("execution(* com.santosh.springaop.manager.*.*(..))")
    public void methodPointCuts() {
    }

    @Around("methodPointCuts()")
    public Object calculateExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Going to call the method.");
        Object output = pjp.proceed();
        System.out.println("Method execution completed.");
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
        return output;
    }
}
