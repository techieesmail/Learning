/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.lambda;

import java.io.Console;

/**
 *
 * @author sanghvir
 */
public class Main {
    static{
        
    }
    {
        
    }
    public static void main(String[] args) {
        //usable only outside IDE
//        Console console  = System.console();
//        System.out.println("Enter your name ");
//        String enteredName = console.readLine();
        String enteredName = "Rahul";
        
        //cannot have lambda as a statement
        //() -> System.out.println("This is statement Lambda "+enteredName);
        //Lambda as an assignment
        FuncInterface func = () -> {
            System.out.println("The name in the impl is  "+enteredName);
            return "Dummy";
        };
        func.sayName();
        //calling default interface of func
        func.sayDefault();
        
        //FuncInter as parameter lambda expression
        
        funcInterAsParam(()-> {
            System.out.println("I will be called from another static method ");
            return "Rahul";
        });
        
         funcInterAsParam(()-> {
            System.out.println("I will be called from another static method ");
            return "Static Method";
        });
        System.out.println("*************************************************");
        DefaultInterImpl impl = new DefaultInterImpl();
        impl.whoami();
        impl.anotherDefault(); 
        
        System.out.println("Calling the static default method ");
        DefaultInter.staticDefault();
    }
    
    static void funcInterAsParam(FuncInterface funcInter){
        System.out.println("Calling the sayHello of FuncInter ");
        funcInter.sayName();
    }
}
