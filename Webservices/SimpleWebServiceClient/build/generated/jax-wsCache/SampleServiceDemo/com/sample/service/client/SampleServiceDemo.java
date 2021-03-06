
package com.sample.service.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SampleServiceDemo", targetNamespace = "http://service.simple.com/", wsdlLocation = "file:/E:/Rahul/Tuition/NewBatch/Nitu/xml-resources/SampleServiceDemo.wsdl")
public class SampleServiceDemo
    extends Service
{

    private final static URL SAMPLESERVICEDEMO_WSDL_LOCATION;
    private final static WebServiceException SAMPLESERVICEDEMO_EXCEPTION;
    private final static QName SAMPLESERVICEDEMO_QNAME = new QName("http://service.simple.com/", "SampleServiceDemo");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/E:/Rahul/Tuition/NewBatch/Nitu/xml-resources/SampleServiceDemo.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SAMPLESERVICEDEMO_WSDL_LOCATION = url;
        SAMPLESERVICEDEMO_EXCEPTION = e;
    }

    public SampleServiceDemo() {
        super(__getWsdlLocation(), SAMPLESERVICEDEMO_QNAME);
    }

    public SampleServiceDemo(WebServiceFeature... features) {
        super(__getWsdlLocation(), SAMPLESERVICEDEMO_QNAME, features);
    }

    public SampleServiceDemo(URL wsdlLocation) {
        super(wsdlLocation, SAMPLESERVICEDEMO_QNAME);
    }

    public SampleServiceDemo(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SAMPLESERVICEDEMO_QNAME, features);
    }

    public SampleServiceDemo(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SampleServiceDemo(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SimpleService
     */
    @WebEndpoint(name = "SimpleServicePort")
    public SimpleService getSimpleServicePort() {
        return super.getPort(new QName("http://service.simple.com/", "SimpleServicePort"), SimpleService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SimpleService
     */
    @WebEndpoint(name = "SimpleServicePort")
    public SimpleService getSimpleServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.simple.com/", "SimpleServicePort"), SimpleService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SAMPLESERVICEDEMO_EXCEPTION!= null) {
            throw SAMPLESERVICEDEMO_EXCEPTION;
        }
        return SAMPLESERVICEDEMO_WSDL_LOCATION;
    }

}
