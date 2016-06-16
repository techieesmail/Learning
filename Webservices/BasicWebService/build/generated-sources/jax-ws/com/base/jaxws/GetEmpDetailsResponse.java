
package com.base.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.employee.details.Employee;

@XmlRootElement(name = "getEmpDetailsResponse", namespace = "http://base.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEmpDetailsResponse", namespace = "http://base.com/")
public class GetEmpDetailsResponse {

    @XmlElement(name = "return", namespace = "")
    private Employee _return;

    /**
     * 
     * @return
     *     returns Employee
     */
    public Employee getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Employee _return) {
        this._return = _return;
    }

}
