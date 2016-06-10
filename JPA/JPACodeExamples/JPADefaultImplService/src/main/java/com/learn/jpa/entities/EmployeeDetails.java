/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sanghvir
 */
@Entity
@Table(name = "EMPLOYEE_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeDetails.findAll", query = "SELECT e FROM EmployeeDetails e"),
    @NamedQuery(name = "EmployeeDetails.findByEmailid", query = "SELECT e FROM EmployeeDetails e WHERE e.emailid = :emailid"),
    @NamedQuery(name = "EmployeeDetails.findByJoiningdate", query = "SELECT e FROM EmployeeDetails e WHERE e.joiningdate = :joiningdate"),
    @NamedQuery(name = "EmployeeDetails.findBySalary", query = "SELECT e FROM EmployeeDetails e WHERE e.salary = :salary"),
    @NamedQuery(name = "EmployeeDetails.findByEmployeeId", query = "SELECT e FROM EmployeeDetails e WHERE e.employeeId = :employeeId")})
public class EmployeeDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "EMAILID")
    private String emailid;
    @Column(name = "JOININGDATE")
    @Temporal(TemporalType.DATE)
    private Date joiningdate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARY")
    private Double salary;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "IDEMPLOYEE", insertable = false, updatable = false)
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    private Employee employee;

    public EmployeeDetails() {
    }

    public EmployeeDetails(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public Date getJoiningdate() {
        return joiningdate;
    }

    public void setJoiningdate(Date joiningdate) {
        this.joiningdate = joiningdate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeDetails)) {
            return false;
        }
        EmployeeDetails other = (EmployeeDetails) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.learn.jpa.jpadefaultimplservice.EmployeeDetails[ employeeId=" + employeeId + " ]";
    }
    
}
