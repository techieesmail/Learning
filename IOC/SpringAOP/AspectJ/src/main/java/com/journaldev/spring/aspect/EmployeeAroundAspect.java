package com.journaldev.spring.aspect;

import com.journaldev.spring.model.Employee;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmployeeAroundAspect {

	@Around("@annotation(com.journaldev.spring.aspect.Loggable)")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("Before invoking getName() method");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
                        Employee emp =(Employee) proceedingJoinPoint.getTarget();
                        Loggable log = emp.getClass().getAnnotation(Loggable.class);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("After invoking getName() method. Return value="+value);
		return value;
	}
}
