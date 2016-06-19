/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.my.entities;

import com.thejavageek.jpa.entities.Department;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author sanghvir
 */
@Entity
@Access(AccessType.FIELD)
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long companyId;
    
    @OneToMany(mappedBy = "company" ,cascade = CascadeType.ALL)
    List<Department> department;

    private String cpnyName;

    public String getCpnyName() {
        return cpnyName;
    }

    public void setCpnyName(String cpnyName) {
        this.cpnyName = cpnyName;
    }
    
    
    
    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }
    
    
    
}
