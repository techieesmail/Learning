/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anyelement;

/**
 *
 * @author Family
 */
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
 
@XmlRegistry
public class ObjectFactory {
 
    @XmlElementDecl(name="bar")
    public JAXBElement<Bar> createBar(Bar bar) {
        return new JAXBElement<Bar>(new QName("bar"), Bar.class, bar);
    }
 
}
