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
@WebService(serviceName = "PrimitiveWebServiceService", portName = "PrimitiveWebServicePort", endpointInterface = "com.base.service.PrimitiveWebService", targetNamespace = "http://service.base.com/", wsdlLocation = "WEB-INF/wsdl/Multi1/PrimitiveWebServiceService.wsdl")
public class Multi1 {

    public java.lang.String baseMethod(java.lang.String arg0) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
