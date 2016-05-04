/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.cdi.alternatives;

import javax.inject.Named;

/**
 *
 * @author SanghviR
 */
@Named("beana")
public class BeanA implements IBean{
    
    @Override
    public void sayHello(){
        System.out.println("Hello from Bean A");
    }
}
