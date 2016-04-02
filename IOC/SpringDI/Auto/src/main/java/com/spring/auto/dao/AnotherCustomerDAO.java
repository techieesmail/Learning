/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spring.auto.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Family
 */
@Repository
public class AnotherCustomerDAO implements ICustomerDAO{
    
    @Override
    public String toString() {
        return "Hello , This is CustomerDAO";
    }

    @Override
    public String sayHello() {
        System.out.println("Hi this is the another implementation class");
        return "Another Implementation called";
    }
    
}
