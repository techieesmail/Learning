/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.serialization;

/**
 *
 * @author SanghviR
 */
public class ParentClass {

    int parent = 10;
    public ParentClass() {
        System.out.println("Parent class constructor is called ");
    }
    
    
    public void overRideMethod(){
        System.out.println("Parent method being called ");
    }
}
