package com.simple.spring.ioc;

import com.simple.spring.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "SpringBeans.xml");

        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        obj.printHello();

        //JavaConfig class test
        ApplicationContext annoContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Customer customer = (Customer) annoContext.getBean("customer");
        customer.printMsg("Hello 1");

        Employee scheduler = (Employee) annoContext.getBean("employee");
        scheduler.printMsg("Hello 2");
    }
}
