/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.auto.bean.scope;

import java.lang.reflect.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author SanghviR
 */
@Component
public class SingletonClass {

    @Autowired
    private Prototype proto;
    
    public SingletonClass() {
        System.out.println("Singleton class "+this);
    }
    
    public void sayHello(){
        //System.out.println(Proxy.isProxyClass(proto.getClass()));
        //Identifying if the injected bean is proxy
        System.out.println(proto.getClass().getName());
        proto.sayHelloFromProto();
    }
}
