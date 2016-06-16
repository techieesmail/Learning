
package com.service.asymmetric;

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
@WebServiceClient(name = "AsymmetricWebService", targetNamespace = "http://asymmetric.service.com/", wsdlLocation = "http://localhost:2000/SecureServices/AsymmetricWebService?wsdl")
public class AsymmetricWebService_Service
    extends Service
{

    private final static URL ASYMMETRICWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException ASYMMETRICWEBSERVICE_EXCEPTION;
    private final static QName ASYMMETRICWEBSERVICE_QNAME = new QName("http://asymmetric.service.com/", "AsymmetricWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:2000/SecureServices/AsymmetricWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ASYMMETRICWEBSERVICE_WSDL_LOCATION = url;
        ASYMMETRICWEBSERVICE_EXCEPTION = e;
    }

    public AsymmetricWebService_Service() {
        super(__getWsdlLocation(), ASYMMETRICWEBSERVICE_QNAME);
    }

    public AsymmetricWebService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), ASYMMETRICWEBSERVICE_QNAME, features);
    }

    public AsymmetricWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, ASYMMETRICWEBSERVICE_QNAME);
    }

    public AsymmetricWebService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ASYMMETRICWEBSERVICE_QNAME, features);
    }

    public AsymmetricWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AsymmetricWebService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AsymmetricWebService
     */
    @WebEndpoint(name = "AsymmetricWebServicePort")
    public AsymmetricWebService getAsymmetricWebServicePort() {
        return super.getPort(new QName("http://asymmetric.service.com/", "AsymmetricWebServicePort"), AsymmetricWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AsymmetricWebService
     */
    @WebEndpoint(name = "AsymmetricWebServicePort")
    public AsymmetricWebService getAsymmetricWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://asymmetric.service.com/", "AsymmetricWebServicePort"), AsymmetricWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ASYMMETRICWEBSERVICE_EXCEPTION!= null) {
            throw ASYMMETRICWEBSERVICE_EXCEPTION;
        }
        return ASYMMETRICWEBSERVICE_WSDL_LOCATION;
    }

}