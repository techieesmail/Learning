/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multipleportserviceclient;

import com.client.multiple.ports.PrimitiveWebService;
import com.client.multiple.ports.PrimitiveWebService1;
import com.client.multiple.ports.PrimitiveWebServiceService;

/**
 *
 * @author Family
 */
public class MultiplePortServiceClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        PrimitiveWebServiceService service = new PrimitiveWebServiceService();
        
        //PrimitiveWebService port = service.getPrimitiveWebServicePort();
        PrimitiveWebService1 port = service.getPrimitiveWebServicePort1();
        System.out.println("The return type is "+port.baseMethod1("Rahul"));
        
    }
}
