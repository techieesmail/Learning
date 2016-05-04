/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author SanghviR
 */
@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestBean {

    
    public RequestBean() {
        System.out.println("Request bean "+this);
    }
    
    public void sayHello(){
        System.out.println("Hello from request bean ");
    }

}
