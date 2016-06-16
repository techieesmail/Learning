/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Family
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"name","id"})
public class Employee {
    
    @XmlElement(name="empName")
    private String name;
    @XmlElement(name = "empId")
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
