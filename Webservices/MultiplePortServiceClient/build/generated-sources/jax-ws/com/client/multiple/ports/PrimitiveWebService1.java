
package com.client.multiple.ports;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PrimitiveWebService1", targetNamespace = "http://service.base.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PrimitiveWebService1 {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "baseMethod1", targetNamespace = "http://service.base.com/", className = "com.client.multiple.ports.BaseMethod")
    @ResponseWrapper(localName = "baseMethodResponse1", targetNamespace = "http://service.base.com/", className = "com.client.multiple.ports.BaseMethodResponse")
    @Action(input = "http://service.base.com/PrimitiveWebService/baseMethodRequest", output = "http://service.base.com/PrimitiveWebService/baseMethodResponse")
    public String baseMethod1(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}