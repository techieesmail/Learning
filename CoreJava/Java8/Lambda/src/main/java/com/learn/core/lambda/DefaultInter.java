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
public interface DefaultInter {
    
    default void whoami(){
        System.out.println("I am a defaultInter interface ");
    }
    default void anotherDefault(){
        System.out.println("This is another default method");
    }
    
    static void staticDefault(){
        System.out.println("This is static default ");
    }
}
