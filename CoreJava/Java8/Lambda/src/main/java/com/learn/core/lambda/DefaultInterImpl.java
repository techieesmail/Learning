/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.lambda;

/**
 *
 * @author sanghvir
 */
public class DefaultInterImpl implements DefaultInter,DefaultInter2{

    @Override
    public void whoami() {
        System.out.println("Calling super method of defaultInter2 ");
        DefaultInter2.super.whoami(); 
        
        FuncInterface inter = () -> "Rahul";
        inter.sayName();
    }
    
    
}
