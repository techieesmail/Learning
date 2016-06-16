
package com.sample.service.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomException complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exceptId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="excepType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomException", propOrder = {
    "exceptId",
    "excepType"
})
public class CustomException {

    protected Integer exceptId;
    protected String excepType;

    /**
     * Gets the value of the exceptId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExceptId() {
        return exceptId;
    }

    /**
     * Sets the value of the exceptId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExceptId(Integer value) {
        this.exceptId = value;
    }

    /**
     * Gets the value of the excepType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExcepType() {
        return excepType;
    }

    /**
     * Sets the value of the excepType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExcepType(String value) {
        this.excepType = value;
    }

}
