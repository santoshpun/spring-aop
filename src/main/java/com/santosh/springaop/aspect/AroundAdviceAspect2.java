package com.santosh.springaop.aspect;

import com.santosh.springaop.manager.LoginResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAdviceAspect2 {

    //here (..) denotes 0 or more arguments in a method
    @Pointcut("execution(* com.santosh.springaop.manager.LoginManager.setParameters(..))")
    public void logMethodPointCut() {
    }

    @Around("logMethodPointCut()")
    public Object logMethod(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();

        if (args.length > 0) {
            System.out.print("Arguments passed: ");
            for (int i = 0; i < args.length; i++) {
                System.out.print("arg" + (i + 1) + ": " + args[i] + ", ");
            }
            System.out.println();
        }
        Object output = pjp.proceed();
        return output;
    }

    @AfterReturning(pointcut = "execution(* com.santosh.springaop.manager.LoginManager.doLogin(..))",
            returning = "retVal")
    public void afterReturningAdvice(JoinPoint jp, Object retVal) {
        System.out.println("Method Signature: " + jp.getSignature());

        if (retVal instanceof LoginResponse) {
            LoginResponse loginResponse = (LoginResponse) retVal;
            System.out.println(loginResponse.isSuccess());
            System.out.println(loginResponse.getMessage());
            System.out.println(loginResponse.getId());
            System.out.println(loginResponse.getUsername());
            System.out.println(loginResponse.getName());
        }
    }
}
