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
public class Main {
    public static void main(String[] args) {
        GenericObj<ActualObj1> g = new GenericObj<>();
        GenericObj<ActualObj2> g1 = new GenericObj<>();
        g.setObj(new ActualObj1());
        g1.setObj(new ActualObj2());
        g.printStringObj();
        g1.printStringObj();
        
        //Generic Methods in non Generic Class
        NonGenericClass c = new NonGenericClass();
        c.setTwoObj(1256.123, 123);
        //GenericObj<Integer> gg = c.getGenericObj(new ActualObj1());
       // System.out.println(gg.getObj());
    }
}
