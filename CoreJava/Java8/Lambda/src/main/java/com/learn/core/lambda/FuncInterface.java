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
@FunctionalInterface
public interface FuncInterface {
    
    String sayName();
    
    default void sayDefault(){
        System.out.println("Default Method of functional interface ");
    }
}
