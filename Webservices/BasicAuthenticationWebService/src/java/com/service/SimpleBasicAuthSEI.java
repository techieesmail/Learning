/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Holder;

/**
 *
 * @author Family
 */
@WebService(name = "BasicAuthSEI")
//@SOAPBinding(style= SOAPBinding.Style.RPC)
public interface SimpleBasicAuthSEI {
  
    @WebMethod(operationName="demoName")
    @WebResult(name="returnName")
    public String showName(@WebParam(name="inputName")String name,@WebParam(name="secondreturn",mode= WebParam.Mode.OUT)Holder<String> id);
    
    
    public String getName(String name);
}
