//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.17 at 11:50:19 PM IST 
//


package choice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the choice package. 
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

    private final static QName _HomeAdress_QNAME = new QName("", "homeAdress");
    private final static QName _OfficeAddress_QNAME = new QName("", "officeAddress");
    private final static QName _Customer_QNAME = new QName("", "customer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: choice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HomeAdress }
     * 
     */
    public HomeAdress createHomeAdress() {
        return new HomeAdress();
    }

    /**
     * Create an instance of {@link OfficeAddress }
     * 
     */
    public OfficeAddress createOfficeAddress() {
        return new OfficeAddress();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HomeAdress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "homeAdress")
    public JAXBElement<HomeAdress> createHomeAdress(HomeAdress value) {
        return new JAXBElement<HomeAdress>(_HomeAdress_QNAME, HomeAdress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OfficeAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "officeAddress")
    public JAXBElement<OfficeAddress> createOfficeAddress(OfficeAddress value) {
        return new JAXBElement<OfficeAddress>(_OfficeAddress_QNAME, OfficeAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "customer")
    public JAXBElement<Customer> createCustomer(Customer value) {
        return new JAXBElement<Customer>(_Customer_QNAME, Customer.class, null, value);
    }

}
