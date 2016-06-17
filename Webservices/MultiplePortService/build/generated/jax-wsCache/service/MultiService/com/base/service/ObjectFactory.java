
package com.base.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.base.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BaseMethod1_QNAME = new QName("http://service.base.com/", "baseMethod1");
    private final static QName _BaseMethod_QNAME = new QName("http://service.base.com/", "baseMethod");
    private final static QName _BaseMethodResponse1_QNAME = new QName("http://service.base.com/", "baseMethodResponse1");
    private final static QName _BaseMethodResponse_QNAME = new QName("http://service.base.com/", "baseMethodResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.base.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BaseMethod }
     * 
     */
    public BaseMethod createBaseMethod() {
        return new BaseMethod();
    }

    /**
     * Create an instance of {@link BaseMethodResponse }
     * 
     */
    public BaseMethodResponse createBaseMethodResponse() {
        return new BaseMethodResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BaseMethod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.base.com/", name = "baseMethod1")
    public JAXBElement<BaseMethod> createBaseMethod1(BaseMethod value) {
        return new JAXBElement<BaseMethod>(_BaseMethod1_QNAME, BaseMethod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BaseMethod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.base.com/", name = "baseMethod")
    public JAXBElement<BaseMethod> createBaseMethod(BaseMethod value) {
        return new JAXBElement<BaseMethod>(_BaseMethod_QNAME, BaseMethod.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BaseMethodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.base.com/", name = "baseMethodResponse1")
    public JAXBElement<BaseMethodResponse> createBaseMethodResponse1(BaseMethodResponse value) {
        return new JAXBElement<BaseMethodResponse>(_BaseMethodResponse1_QNAME, BaseMethodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BaseMethodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.base.com/", name = "baseMethodResponse")
    public JAXBElement<BaseMethodResponse> createBaseMethodResponse(BaseMethodResponse value) {
        return new JAXBElement<BaseMethodResponse>(_BaseMethodResponse_QNAME, BaseMethodResponse.class, null, value);
    }

}
