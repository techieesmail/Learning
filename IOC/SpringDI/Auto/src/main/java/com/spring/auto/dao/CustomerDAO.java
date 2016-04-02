package com.spring.auto.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
@Component("primary")
public class CustomerDAO implements ICustomerDAO {

    @Override
    public String toString() {
        return "Hello , This is CustomerDAO";
    }

    @Override
    public String sayHello() {
        System.out.println("Hi this is the implementation class");
        return "Implementation called";
    }
}
