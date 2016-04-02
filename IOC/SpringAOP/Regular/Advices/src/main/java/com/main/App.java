package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.model.Customer;
import com.spring.model.ICustomer;

public class App {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[]{"Spring.xml"});

        Customer cust = (Customer) appContext.getBean("customerProxy");
        System.out.println("*************************" + cust.getClass().getSuperclass());
        cust.printName();
        System.out.println("*************************");
        cust.printURL();
        System.out.println("*************************");
//		try {
//			
//                        System.out.println("Sleeping");
//                        Thread.sleep(300000);
//                        cust.printThrowException();
//		} catch (Exception e) {
//
//		}

    }
}
