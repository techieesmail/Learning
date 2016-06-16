/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Holder;

/**
 *
 * @author Family
 */

@WebService(serviceName = "SimpleBasicAuthService",endpointInterface="com.service.SimpleBasicAuthSEI",portName="TestPort")
public class SimpleBasicAuthService implements SimpleBasicAuthSEI{

    /**
     * This is a sample web service operation
     */
//    @WebMethod(operationName = "hello")
//    public String hello(String txt) {
//        return "Hello " + txt + " !";
//    }

    @Override
    public String showName(String name,Holder<String>id) {
        id.value="SecondResponse";
        return "The name received is"+name;
    }

    
    @Override
    public String getName(String name) {
        System.out.println("SayHello");
        return name;
    }
}
