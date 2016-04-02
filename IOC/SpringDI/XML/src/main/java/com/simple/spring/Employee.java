/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.simple.spring;

import java.util.List;

/**
 *
 * @author Family
 */
public class Employee {
    
    private int id;
    
    private String name;
    
    private List<String> phones;
    
    private Address address;
    
    private List<Cars> cars;
    
    //Technology will be set separately using program
    private Technology tech;
    
    private Department dept;

    public Employee(int id, String name, List<String> phones, Address address, List<Cars> cars) {
        this.id = id;
        this.name = name;
        this.phones = phones;
        this.address = address;
        this.cars = cars;
    }
    
    public void displayInfo(){
        System.out.println("The name is "+name);
        System.out.println("The id is "+id);
        System.out.println("The number of phones are "+phones.size());
        System.out.println("The city is "+address.getCity());
        System.out.println("The number of cars are "+cars.size());
        System.out.println("The name of Technology is "+tech.getName());
        System.out.println("The name of department is "+dept.getName());
    }

    //Setter way of injection
    public void setDept(Department dept) {
        this.dept = dept;
    }

    public void setTech(Technology tech) {
        this.tech = tech;
    }
    
    
    
}
