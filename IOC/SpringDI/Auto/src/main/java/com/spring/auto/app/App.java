package com.spring.auto.app;

import com.spring.auto.bean.scope.SingletonClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.auto.service.CustomerService;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = 
    		new ClassPathXmlApplicationContext(new String[] {"Spring-AutoScan.xml"});

    	CustomerService cust = (CustomerService)context.getBean("customerService");
        SingletonClass s = (SingletonClass)context.getBean("singletonClass");
        s.sayHello();
        s.sayHello();
    	//System.out.println(cust);
       // cust.sayHello();
    	
    }
}
