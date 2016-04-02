package com.simple.spring.config;

import com.simple.spring.ioc.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EmployeeConfig {
	
	@Bean(name="employee")
	public Employee employee(){
		
		return new Employee();
		
	}
	
}