/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.fault;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Family
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"exceptId","excepType"})
public class CustomException extends Exception {
    
    private Integer exceptId;
    private String excepType;

    public Integer getExceptId() {
        return exceptId;
    }

    public void setExceptId(Integer exceptId) {
        this.exceptId = exceptId;
    }

    public String getExcepType() {
        return excepType;
    }

    public void setExcepType(String excepType) {
        this.excepType = excepType;
    }
    
    
    
    
}
