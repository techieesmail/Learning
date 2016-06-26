/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.equalshash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author sanghvir
 */
public class MainClass {
    public static void main(String[] args) {
        //Comments testing
        HashMap m = new HashMap();
        Employee e1 = new Employee(1);
        Employee e2 = new Employee(1);
        m.put(e1, "Rahul");
        m.put(e2, "venkat");
        
        System.out.println("Equality check "+e1.equals(e2));
        System.out.println("The size "+m.size());
        
        Set s = m.entrySet();
        
        HashSet hs = new HashSet();
        hs.add(e1);
        hs.add(e2);
        System.out.println("The hashset size is "+hs.size());
        System.out.println("The value is "+hs.contains(e1));
        System.out.println(m.get(e2));
       // new Employee(1).testRuntime();
       
        List l = new ArrayList();
        l.add(l);
        l.add(2);
        Iterator i = l.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
            //l.add(3);
        }
        HashMap h = new HashMap();
        h.put("1", l);
        h.put("1", 2);
        
        h.entrySet();
    }
}


class Employee{
    int i;

    public Employee(int i) {
        this.i = i;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if(obj == null)
//            return false;
//        if(! (obj instanceof Employee))
//            return false;
//        if(obj ==  this)
//            return true;
//        if(this.i == ((Employee)obj).i)
//            return true;
//        return false;
//    }

    @Override
    public int hashCode() {
        return this.i;
    }
    
    public void testRuntime() throws RuntimeException{
        System.out.println("Hi from testRuntime ");
    }
    
    
}
