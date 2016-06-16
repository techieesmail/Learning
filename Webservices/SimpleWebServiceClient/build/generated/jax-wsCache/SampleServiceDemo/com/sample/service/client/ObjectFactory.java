
package com.sample.service.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sample.service.client package. 
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

    private final static QName _TestOperation_QNAME = new QName("http://service.simple.com/", "testOperation");
    private final static QName _CustomException_QNAME = new QName("http://service.simple.com/", "CustomException");
    private final static QName _EmpReturn_QNAME = new QName("http://service.simple.com/", "empReturn");
    private final static QName _TestOperationResponse_QNAME = new QName("http://service.simple.com/", "testOperationResponse");
    private final static QName _EmpReturnResponse_QNAME = new QName("http://service.simple.com/", "empReturnResponse");
    private final static QName _MyHeader_QNAME = new QName("http://service.simple.com/", "myHeader");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sample.service.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EmpReturn }
     * 
     */
    public EmpReturn createEmpReturn() {
        return new EmpReturn();
    }

    /**
     * Create an instance of {@link CustomException }
     * 
     */
    public CustomException createCustomException() {
        return new CustomException();
    }

    /**
     * Create an instance of {@link TestOperation }
     * 
     */
    public TestOperation createTestOperation() {
        return new TestOperation();
    }

    /**
     * Create an instance of {@link EmpReturnResponse }
     * 
     */
    public EmpReturnResponse createEmpReturnResponse() {
        return new EmpReturnResponse();
    }

    /**
     * Create an instance of {@link TestOperationResponse }
     * 
     */
    public TestOperationResponse createTestOperationResponse() {
        return new TestOperationResponse();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.simple.com/", name = "testOperation")
    public JAXBElement<TestOperation> createTestOperation(TestOperation value) {
        return new JAXBElement<TestOperation>(_TestOperation_QNAME, TestOperation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.simple.com/", name = "CustomException")
    public JAXBElement<CustomException> createCustomException(CustomException value) {
        return new JAXBElement<CustomException>(_CustomException_QNAME, CustomException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmpReturn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.simple.com/", name = "empReturn")
    public JAXBElement<EmpReturn> createEmpReturn(EmpReturn value) {
        return new JAXBElement<EmpReturn>(_EmpReturn_QNAME, EmpReturn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestOperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.simple.com/", name = "testOperationResponse")
    public JAXBElement<TestOperationResponse> createTestOperationResponse(TestOperationResponse value) {
        return new JAXBElement<TestOperationResponse>(_TestOperationResponse_QNAME, TestOperationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmpReturnResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.simple.com/", name = "empReturnResponse")
    public JAXBElement<EmpReturnResponse> createEmpReturnResponse(EmpReturnResponse value) {
        return new JAXBElement<EmpReturnResponse>(_EmpReturnResponse_QNAME, EmpReturnResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.simple.com/", name = "myHeader")
    public JAXBElement<String> createMyHeader(String value) {
        return new JAXBElement<String>(_MyHeader_QNAME, String.class, null, value);
    }

}
