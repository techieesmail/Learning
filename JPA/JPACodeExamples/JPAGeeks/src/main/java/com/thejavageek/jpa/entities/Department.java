package com.thejavageek.jpa.entities;

import com.jpa.my.entities.Company;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Department {

	@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
	private int iddepartment;
	private String name;

        @ManyToOne(cascade = CascadeType.ALL)
        private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
        
        
        
	public int getIddepartment() {
		return iddepartment;
	}

	public void setIddepartment(int iddepartment) {
		this.iddepartment = iddepartment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [iddepartment=" + iddepartment + ", name=" + name
				+ "]";
	}

}