/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.details;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Family
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="EmpDetails",propOrder={"name","phone"})

public class Employee 
{
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
    
}
