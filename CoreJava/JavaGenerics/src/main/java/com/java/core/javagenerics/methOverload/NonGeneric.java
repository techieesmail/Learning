/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.core.javagenerics.methOverload;

/**
 *
 * @author SanghviR
 */
public class NonGeneric {
    
    public void method(Object...objects){
        System.out.println("Inside object varags");
    }
    public void method(Object i , Object...o){
        System.out.println("Inside one object varag");
        
    }
    
    public static void main(String[] args) {
        NonGeneric non = new NonGeneric();
        //non.method("R","S");
    }
}
