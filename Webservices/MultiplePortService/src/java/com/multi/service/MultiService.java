/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multi.service;

import javax.jws.WebService;

/**
 *
 * @author Family
 */
@WebService(serviceName = "PrimitiveWebServiceService", portName = "PrimitiveWebServicePort", endpointInterface = "com.base.service.PrimitiveWebService", targetNamespace = "http://service.base.com/", wsdlLocation = "WEB-INF/wsdl/PrimitiveWebServiceService.wsdl")
public class MultiService {

    public java.lang.String baseMethod(java.lang.String arg0) {
        //TODO implement this method
        System.out.println("This is basemethod ");
        return arg0;
    }
    
}
