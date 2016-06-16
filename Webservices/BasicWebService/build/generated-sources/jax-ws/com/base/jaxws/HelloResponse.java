
package com.base.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "bbyeResponse", namespace = "http://base.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bbyeResponse", namespace = "http://base.com/", propOrder = {
    "testResult",
    "testOut"
})
public class HelloResponse {

    @XmlElement(name = "testResult", namespace = "")
    private String testResult;
    @XmlElement(name = "testOut", namespace = "")
    private String testOut;

    /**
     * 
     * @return
     *     returns String
     */
    public String getTestResult() {
        return this.testResult;
    }

    /**
     * 
     * @param testResult
     *     the value for the testResult property
     */
    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getTestOut() {
        return this.testOut;
    }

    /**
     * 
     * @param testOut
     *     the value for the testOut property
     */
    public void setTestOut(String testOut) {
        this.testOut = testOut;
    }

}
