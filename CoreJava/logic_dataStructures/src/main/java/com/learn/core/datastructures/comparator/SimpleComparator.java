/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.datastructures.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author SanghviR
 */
public class SimpleComparator {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "Rahul";
        e.salary = 10000;

        Employee e1 = new Employee();
        e1.name = "Zero";
        e1.salary = 5000;

        Employee e2 = new Employee();
        e2.name = "Rakesh";
        e2.salary = 20000;

        Employee e3 = new Employee();
        e3.name = "Shravan";
        e3.salary = 35000;

        List<Employee> ls = new ArrayList<>();
        ls.add(e);
        ls.add(e1);
        ls.add(e2);
        ls.add(e3);
        int a  =10;
        switch(a){
            case 10 : {
                System.out.println("Matched found ");
                break;
            }
            default : {
                System.out.println("In default");
            }
        }
            
        System.out.println("The original list " + ls);
        
        EmployeeComparator s = new EmployeeComparator();
        Collections.sort(ls, s);

        System.out.println("After using comparator the list " + ls);
        

        ValueComparator v = new ValueComparator();
        HashMap<String, Employee> h = new HashMap<>();
         v.setMap(h);
        
        h.put("Rahul", e);
        h.put("Zero", e1);
        h.put("Rakesh", e2);
        h.put("Shravan", e3);
        
        
        TreeMap<String, Employee> tm = new TreeMap<>(v);
        
        
       
        
        tm.put("Rahul", e);
        tm.put("Zero", e1);
        tm.put("Rakesh", e2);
        tm.put("Shravan", e3);
        
        
        System.out.println("The elements in tm is "+tm);
        

        
    }
    
    public static void varags(String...values){
        int l = values.length;
    }

}

class Employee {

    public String name;
    public long salary;

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", salary=" + salary + '}';
    }
}

class ValueComparator implements Comparator<String> {

    private Map<String, Employee> map;

    ValueComparator() {
        
    }

    public void setMap(Map<String, Employee> map){
        this.map = map;
    }
    @Override
    public int compare(String o1, String o2) {
        Employee e1 = map.get(o1);
        Employee e2 = map.get(o2);

        long s1 = e1.salary;
        long s2 = e2.salary;

        if (s1 < s2) {
            return 1;
        } else if (s1 == s2) {
            return 0;
        } else {
            return -1;
        }

    }

}

class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.salary < o2.salary) {
            return 1;
        } else {
            return -1;
        }
    }

}
