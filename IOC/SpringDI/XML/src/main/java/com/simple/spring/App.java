/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.simple.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author Family
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "SpringBeans.xml");

        Employee emp = (Employee)context.getBean("employee");
        Technology technology = (Technology)context.getBean("tech");
        technology.setName("Java");
        emp.setTech(technology);
        
        emp.displayInfo();
        
        //Another way of accessing bean
        Resource r= new ClassPathResource("SpringBeans.xml");  
        BeanFactory factory= new XmlBeanFactory(r);
        Address add = (Address) factory.getBean("childAdd");
        System.out.println("The address is "+add.getCity());
        
        
        //Scope Test
        ScopeBean bean = (ScopeBean)context.getBean("scopeBean");
        bean.setMessage("Hello Boss");
        System.out.println("The bean message is "+bean.getMessage());
        
        //Since the scope is prototype , retrieving again will nullify the instance.
        ScopeBean beanAgain = (ScopeBean)context.getBean("scopeBean");
        System.out.println("The bean message is "+beanAgain.getMessage());
        
    }
    
}
