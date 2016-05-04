/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.cdi.interceptors;

/**
 *
 * @author SanghviR
 */
@LoggingInterceptorAnnot
public class LoggingInterceptorBean {
    public String sayHello(){
        System.out.println("Hey Hi ");
        return "Rahul";
    }
}
