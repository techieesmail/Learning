/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sanghvir
 */
@Entity
@Table(name = "JPA_TABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JpaTable.findAll", query = "SELECT j FROM JpaTable j"),
    @NamedQuery(name = "JpaTable.findByPkcol", query = "SELECT j FROM JpaTable j WHERE j.pkcol = :pkcol"),
    @NamedQuery(name = "JpaTable.findByTeststring", query = "SELECT j FROM JpaTable j WHERE j.teststring = :teststring")})
public class JpaTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PKCOL")
    private Long pkcol;
    @Size(max = 255)
    @Column(name = "TESTSTRING")
    private String teststring;

    public JpaTable() {
    }

    public JpaTable(Long pkcol) {
        this.pkcol = pkcol;
    }

    public Long getPkcol() {
        return pkcol;
    }

    public void setPkcol(Long pkcol) {
        this.pkcol = pkcol;
    }

    public String getTeststring() {
        return teststring;
    }

    public void setTeststring(String teststring) {
        this.teststring = teststring;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkcol != null ? pkcol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JpaTable)) {
            return false;
        }
        JpaTable other = (JpaTable) object;
        if ((this.pkcol == null && other.pkcol != null) || (this.pkcol != null && !this.pkcol.equals(other.pkcol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.learn.jpa.jpadefaultimplservice.JpaTable[ pkcol=" + pkcol + " ]";
    }
    
}
