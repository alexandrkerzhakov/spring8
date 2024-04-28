package ru.gb.spring8.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
public class LoggingAspect {

    @AfterReturning(value = "@annotation(Action)", returning = "returnedValue")
    public void log(Object returnedValue) {
        System.out.println("Method executed and returned " + returnedValue);
    }

    @Around("execution(* ru.gb.spring8.service.*.*(..))")
    @Order(1)
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Method run-> " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        System.out.println("Method close-> " + joinPoint.getSignature().getName());
        return result;
    }

    @Around("execution(* ru.gb.spring8.service.*.*(..))")
    @Order(2)
    public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Method time: " + elapsedTime + " millisecond");
        return result;
    }
}
