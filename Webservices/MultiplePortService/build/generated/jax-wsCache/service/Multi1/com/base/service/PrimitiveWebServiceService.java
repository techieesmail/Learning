
package com.base.service;

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
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "PrimitiveWebServiceService", targetNamespace = "http://service.base.com/", wsdlLocation = "file:/E:/Rahul/Workspace/NetBeans/MultiplePortService/src/conf/xml-resources/web-services/Multi1/wsdl/PrimitiveWebServiceService.wsdl")
public class PrimitiveWebServiceService
    extends Service
{

    private final static URL PRIMITIVEWEBSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException PRIMITIVEWEBSERVICESERVICE_EXCEPTION;
    private final static QName PRIMITIVEWEBSERVICESERVICE_QNAME = new QName("http://service.base.com/", "PrimitiveWebServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/E:/Rahul/Workspace/NetBeans/MultiplePortService/src/conf/xml-resources/web-services/Multi1/wsdl/PrimitiveWebServiceService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PRIMITIVEWEBSERVICESERVICE_WSDL_LOCATION = url;
        PRIMITIVEWEBSERVICESERVICE_EXCEPTION = e;
    }

    public PrimitiveWebServiceService() {
        super(__getWsdlLocation(), PRIMITIVEWEBSERVICESERVICE_QNAME);
    }

    public PrimitiveWebServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns PrimitiveWebService
     */
    @WebEndpoint(name = "PrimitiveWebServicePort")
    public PrimitiveWebService getPrimitiveWebServicePort() {
        return super.getPort(new QName("http://service.base.com/", "PrimitiveWebServicePort"), PrimitiveWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PrimitiveWebService
     */
    @WebEndpoint(name = "PrimitiveWebServicePort")
    public PrimitiveWebService getPrimitiveWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.base.com/", "PrimitiveWebServicePort"), PrimitiveWebService.class, features);
    }

    /**
     * 
     * @return
     *     returns PrimitiveWebService1
     */
    @WebEndpoint(name = "PrimitiveWebServicePort1")
    public PrimitiveWebService1 getPrimitiveWebServicePort1() {
        return super.getPort(new QName("http://service.base.com/", "PrimitiveWebServicePort1"), PrimitiveWebService1.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PrimitiveWebService1
     */
    @WebEndpoint(name = "PrimitiveWebServicePort1")
    public PrimitiveWebService1 getPrimitiveWebServicePort1(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.base.com/", "PrimitiveWebServicePort1"), PrimitiveWebService1.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PRIMITIVEWEBSERVICESERVICE_EXCEPTION!= null) {
            throw PRIMITIVEWEBSERVICESERVICE_EXCEPTION;
        }
        return PRIMITIVEWEBSERVICESERVICE_WSDL_LOCATION;
    }

}
