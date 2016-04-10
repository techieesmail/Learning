/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.standalone.aspectJ;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectWithoutXML {
    
    @Before("execution(* HelloWorld.sayHello(..))")
    public void BeforeAdvice(){
        System.out.println("Before advice called. This aspect is not mentioned in xml file. ");
    }
}
