/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.equalshash;

import java.util.HashMap;

/**
 *
 * @author sanghvir
 */
public class MainClass {
    public static void main(String[] args) {
        HashMap m = new HashMap();
        m.put(new Employee(1), "Rahul");
        m.put(new Employee(1), "venkat");
        System.out.println("The size "+m.size());
        System.out.println(m.get(new Employee(1)));
        new Employee(1).testRuntime();
    }
}


class Employee{
    int i;

    public Employee(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(! (obj instanceof Employee))
            return false;
        if(obj ==  this)
            return true;
        if(this.i == ((Employee)obj).i)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.i;
    }
    
    public void testRuntime() throws RuntimeException{
        System.out.println("Hi from testRuntime ");
    }
    
    
}
