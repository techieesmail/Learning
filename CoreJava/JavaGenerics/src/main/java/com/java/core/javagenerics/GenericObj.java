/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.core.javagenerics;

/**
 *
 * @author SanghviR
 */
public class GenericObj<T> {
    private T t;

    public GenericObj() {
        System.out.println("This is a non generic constructor ");
    }
    
    
    public void setObj(T t){
        this.t = t;
    }
    
    public void printStringObj(){
        System.out.println("Print to string called in genericObj ");
        System.out.println(t.toString());
    }
    
    public T getObj(){
        return t;
    }
    
}
