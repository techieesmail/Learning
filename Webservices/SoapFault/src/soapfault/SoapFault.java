/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package soapfault;

import com.client.stub.CustomException;
import com.client.stub.CustomException_Exception;
import com.client.stub.SimpleService;
import com.client.stub.SimpleService_Service;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author Family
 */
public class SoapFault {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    
        URL u = SimpleService_Service.class.getClassLoader().getResource("META-INF/xml-resources/SimpleService.wsdl");
        SimpleService_Service service = new SimpleService_Service(u, new QName("http://service.simple.com/", "SimpleService"));
        
//        SimpleService_Service service = new SimpleService_Service();
//
        SimpleService port = service.getSimpleServicePort();
        BindingProvider provider = (BindingProvider) port;
        provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:2000/SimpleService");
        try {
            
            port.empReturn("Rahul");
        } catch (CustomException_Exception ex) {
            CustomException excep = ex.getFaultInfo();
            System.out.println("The exception id is "+excep.getExceptId());
            
        }
        
        
        //port.empReturn("Rahul");
//        Hello hello = new Hello();
//        hello.setName("Rahul");
//        HelloResponse response = port.hello(hello, null);
//        System.out.println("The return value is "+response.getFullName());
        
    }
}
