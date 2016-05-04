/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author SanghviR
 */
@Component("sessionBean")
@Scope("session")
public class SessionBean {

  @Autowired  private RequestBean request;
    public SessionBean() {
        System.out.println("Session bean "+this);
    }
    
    public void sayHello(){
        request.sayHello();
    }
    
}
