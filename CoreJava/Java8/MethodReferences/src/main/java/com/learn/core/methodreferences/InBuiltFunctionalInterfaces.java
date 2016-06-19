/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.methodreferences;

import java.util.function.DoubleToIntFunction;
import java.util.function.Predicate;

/**
 *
 * @author sanghvir
 */
public class InBuiltFunctionalInterfaces {
    public static void main(String[] args) {
        InBuiltFunctionalInterfaces app =  new InBuiltFunctionalInterfaces();
        System.out.println(app.myDoubleToInt(app::DoubleTointMyFunc , 152.896));
        
        //method ref assignment
        Predicate<Boolean> pre = app::mypredicate;
        //below is the same thing via lambda expression
        boolean value = false;
        Predicate<Boolean> p = (boolVal) ->  boolVal;
        System.out.println(pre.test(Boolean.TRUE));
        System.out.println("Calling Predicate via lamda "+p.test(value));
    }
    
    public int myDoubleToInt(DoubleToIntFunction inbuiltFun , Double value){
        return inbuiltFun.applyAsInt(value);
    }
    
    public int DoubleTointMyFunc(Double value){
        System.out.println("My Function called ");
        return value.intValue();
    }
    
    public boolean mypredicate(boolean value){
        return value;
    }
}
