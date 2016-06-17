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
@WebService(serviceName = "PrimitiveWebServiceService", portName = "PrimitiveWebServicePort1", endpointInterface = "com.base.service.PrimitiveWebService1", targetNamespace = "http://service.base.com/", wsdlLocation = "WEB-INF/wsdl/Multi2/PrimitiveWebServiceService.wsdl")
public class Multi2 {

    public java.lang.String baseMethod1(java.lang.String arg0) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
