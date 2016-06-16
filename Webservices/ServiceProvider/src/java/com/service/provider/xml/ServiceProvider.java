/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.provider.xml;

import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingType;
import javax.xml.ws.Provider;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;

/**
 *
 * @author Family
 */
@WebServiceProvider(serviceName="SimpleService"
        ,portName="SimpleServicePort1",wsdlLocation="/WEB-INF/xml-resources/ProviderService.wsdl",
        targetNamespace="http://service.simple.com/")
@BindingType(value="http://schemas.xmlsoap.org/wsdl/soap/http")
@ServiceMode(value=javax.xml.ws.Service.Mode.MESSAGE)
public class ServiceProvider implements Provider<SOAPMessage> {

    @Override
    public SOAPMessage invoke(SOAPMessage request) {
        return null;
        
    }
    
}
