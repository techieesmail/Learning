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
public class NonGenericClass {



    public NonGenericClass() {
        System.out.println(this.toString());
    }
    
    //adding generic A to return type will avoid type casting exceptions.
    public <A> GenericObj<A> getGenericObj(A a){
        GenericObj<A> g = new GenericObj<>();
        g.setObj(a);
        return g;
    }
    
    public <T1 extends Number,T2 extends T1> void setTwoObj(T1 t1, T2 t2){
        System.out.println("The type of t1 "+t1.getClass().getName());
         System.out.println("The type of t2 "+t2.getClass().getName());
         
         System.out.println(t1.intValue());
         System.out.println(t2.intValue());
    }
    
}
