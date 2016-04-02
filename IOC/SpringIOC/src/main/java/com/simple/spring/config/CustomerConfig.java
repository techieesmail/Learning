package com.simple.spring.config;

import com.simple.spring.ioc.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class CustomerConfig {
	
	@Bean(name="customer")
	public Customer customer(){
		
		return new Customer();
		
	}
}