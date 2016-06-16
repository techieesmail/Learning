/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base;

import com.employee.details.Employee;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.xml.ws.Holder;

/**
 *
 * @author Family
 */
@WebService(serviceName = "BaseWebService")
//@SOAPBinding(style= SOAPBinding.Style.RPC)
public class BaseWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "bbye")
    @WebResult(name="testResult")
    public String hello(@WebParam(name = "name")String txt,@WebParam(name="testOut",mode= WebParam.Mode.OUT)Holder<String> hi) {
       hi.value = "Sir";
        
        return "Hello " + txt + " !";
    }
    
    //@WebResult(name="empDetails")
    public Employee getEmpDetails(String name)
    {
        Employee e = new Employee();
        e.setName("Rahul");
        e.setPhone("1234");
        
        return e;
    }
}
