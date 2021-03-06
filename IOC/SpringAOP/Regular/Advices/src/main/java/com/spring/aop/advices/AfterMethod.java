package com.spring.aop.advices;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

public class AfterMethod implements AfterReturningAdvice {
	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		System.out.println("AfterMethod Called");
	}
}