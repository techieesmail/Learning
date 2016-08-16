/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SanghviR
 */
public class ChildClass extends ParentClass implements Serializable{
    public int i = 10;
    public Map m = new HashMap();
    
    RegularClass rc = new RegularClass();
    
    public ChildClass() {
        System.out.println("Child class constructor is called ");
    }
    
    public void method1(Number i ,  Number j){
        System.out.println("Super parameters called ");
    }
    
    public void method1(Integer i , Integer j){
       // return i+j;
        System.out.println("Sub parameters called ");
    }

    @Override
    public void overRideMethod() {
        System.out.println("Child method called ");
    }
    
    
//    private void writeObject(ObjectOutputStream out)throws IOException{
//        System.out.println("My WriteObject called ");
//    }
    
     class InnerClass{
        void testMethod() {
            ChildClass.this.overRideMethod();
            ChildClass.super.overRideMethod();
        }
    }
}
