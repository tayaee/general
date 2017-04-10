package com.demo.aop;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NotSoUsefulUppercaseAspect {
    @Around("execution(* com.demo.service.EchoService.echo(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        String me = "NotSoUsefulUppercaseAspect.aroundAdvice()";
        System.out.println(me + " AOP interceptor: begin: " + Arrays.toString(pjp.getArgs()));
        Object result = pjp.proceed();
        result = ((String) result).toUpperCase();
        System.out.println(me + " AOP interceptor: end: " + result);
        return result;
    }
}
