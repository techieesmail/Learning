package com.spring.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.auto.dao.CustomerDAO;
import com.spring.auto.dao.ICustomerDAO;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class CustomerService {

    @Autowired
    @Qualifier("primary")
    ICustomerDAO simpleDAO;

    @Override
    public String toString() {
        return "CustomerService [customerDAO=" + simpleDAO + "]";
    }

    public void sayHello() {
        System.out.println(simpleDAO.sayHello());
    }

}
