/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.methodreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanghvir
 */
public class StaticMethodReference {
// This method has a functional interface as the type of
// its first parameter. Thus, it can be passed any instance
// of that interface, including a method reference.

    static String stringOp(StringFunc sf, String s) {
        System.out.println("StringOp called ");
        try {
            sf.func(s);
        } catch (Exception ex) {
            Logger.getLogger(StaticMethodReference.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Rahul";
    }

    public static void main(String args[]) {
        String inStr = "Lambdas add power to Java";
        String outStr;
        // Here, a method reference to strReverse is passed to stringOp().
        outStr = stringOp(MyStringOps::strReverse, inStr);
        System.out.println("Original string: " + inStr);
        System.out.println("String reversed: " + outStr);
        

    }
}

// A functional interface for string operations.
interface StringFunc {

    String func(String n)throws Exception ;
}

// This class defines a static method called strReverse().
class MyStringOps {
// A static method that reverses a string.

    static String strReverse(String str) throws Exception{
        System.out.println("The reverse called ");
        String result = "";
        int i;
        for (i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}
