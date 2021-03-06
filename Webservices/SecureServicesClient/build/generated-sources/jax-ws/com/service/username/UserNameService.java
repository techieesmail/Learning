
package com.service.username;

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
@WebService(name = "UserNameService", targetNamespace = "http://userName.service.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserNameService {


    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://userName.service.com/", className = "com.service.username.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://userName.service.com/", className = "com.service.username.HelloResponse")
    @Action(input = "http://userName.service.com/UserNameService/helloRequest", output = "http://userName.service.com/UserNameService/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}
