/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basewebserviceclient;


import com.client.stub.DemoService;
import com.client.stub.MultiParamService;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;



//import stub.client.DemoService;
//import stub.client.MultiParamService;

/**
 *
 * @author Family
 */
public class BaseWebServiceClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//       URL u = BaseWebService_Service.class.getClassLoader().getResource("META-INF/xml-resources/BaseWebService.wsdl");
//
//        BaseWebService_Service service = new BaseWebService_Service(u, new QName("http://base.com/", "BaseWebService"));
//        BaseWebService port = service.getBaseWebServicePort();
//        BindingProvider provider = (BindingProvider)port;
//        provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:2000/BasicWebService/BaseWebService");
//        //System.out.println("The response received is "+port.bbye("Rahul"));
//        
//        EmpDetails e = port.getEmpDetails("Rahul");
//        System.out.println("The phone number is "+e.getPhone());
//        System.out.println("The name is "+e.getName());
        
        
        
        
        
        //MultiResponseParams
        
        URL u1 = DemoService.class.getClassLoader().getResource("META-INF/xml-resources/DemoService.wsdl");
        DemoService serv = new DemoService (u1, new QName("http://param.multi.com/", "DemoService"));
        MultiParamService portserv = serv.getMultiParamServicePort();
        BindingProvider multiprovider = (BindingProvider)portserv;
        //multiprovider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:2000/BasicWebService/BaseWebService");
        multiprovider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:2000/MultiService/DemoService");
        portserv.hello("Rahul", null, null);
        
        
//        DemoService service = new DemoService();
//        MultiParamService prot =  service.getMultiParamServicePort();
//        System.out.println("The response received is "+prot.hello("Rahul", null, null));
        
        
        
        
        
       
        
//        
    }
}
