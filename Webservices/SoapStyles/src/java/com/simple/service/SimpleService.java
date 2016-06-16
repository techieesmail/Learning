/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.service;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Family
 */
@WebService(serviceName = "SimpleService")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
@HandlerChain(file = "../../config/SimpleService_handler.xml")
public class SimpleService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    @WebResult(name = "MyResult")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
       
    }
}
