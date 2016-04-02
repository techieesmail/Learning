package com.spring.aop.advices;

import org.springframework.aop.ThrowsAdvice;

public class ThrowException implements ThrowsAdvice {
	public void afterThrowing(IllegalArgumentException e) throws Throwable {
		System.out.println("ThrowException : Throw exception ed!");
	}
}