package com.spring.aop.advices;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("Method name : "
                + methodInvocation.getMethod().getName());
        System.out.println("Method arguments : "
                + Arrays.toString(methodInvocation.getArguments()));

        //same with MethodBeforeAdvice
        System.out.println("Before calling Bean method");

        try {
            //proceed to original method call
            Object result = methodInvocation.proceed();

            //same with AfterReturningAdvice
            System.out.println("After calling bean method");

            return result;

        } catch (IllegalArgumentException e) {
            //same with ThrowsAdvice
            System.out.println("HijackAroundMethod : Throw exception hijacked!");
            throw e;
        }

    }

}
