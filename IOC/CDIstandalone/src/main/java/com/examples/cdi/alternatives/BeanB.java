/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.cdi.alternatives;

/**
 *
 * @author SanghviR
 */
public class BeanB implements IBean{
    
    @Override
    public void sayHello(){
        System.out.println("Hello from Bean B");
    }
}
