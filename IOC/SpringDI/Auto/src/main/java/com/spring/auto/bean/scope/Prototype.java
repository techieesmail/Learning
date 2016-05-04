/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.auto.bean.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author SanghviR
 */
@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Prototype {

    public Prototype() {
        System.out.println("The prototype class "+this);
    }
    
    
    public void sayHelloFromProto(){
        System.out.println("Hello from prototype ");
    }
}
