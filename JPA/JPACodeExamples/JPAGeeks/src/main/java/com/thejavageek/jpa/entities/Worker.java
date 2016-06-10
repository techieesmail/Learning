/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thejavageek.jpa.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author SanghviR
 */
//@Entity
@Table(name = "WORKER")
@SecondaryTable(name = "WORKER_DETAILS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "WORKER_ID"))
public class Worker {

    @SequenceGenerator(name = "seq_gen" ,sequenceName = "ID_SEQ" ,allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    private int idemployee;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME", table = "EMPLOYEE")
    private String lastName;

    @Column(name = "EMAILID", table = "WORKER_DETAILS")
    private String email;

    @Column(table = "WORKER_DETAILS")
    @Temporal(TemporalType.DATE)
    private Date joiningDate;

    @Column(table = "WORKER_DETAILS")
    private double salary;

    public int getIdemployee() {
        return idemployee;
    }

    public void setIdemployee(int idemployee) {
        this.idemployee = idemployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
