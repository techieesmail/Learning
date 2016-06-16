/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package asyncsimplewebserviceclient;

import com.simple.service.SimpleService;
import com.simple.service.SimpleServiceService;
import com.simple.service.TestOperation;
import com.simple.service.TestOperationResponse;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author Family
 */
public class AsyncSimpleWebServiceClient {

    /**
     * @param args the command line arguments
     */
    private static SimpleService port;

    public static void main(String[] args)throws Exception {
        // TODO code application logic here

        URL wsdlUrl = SimpleServiceService.class.getClassLoader().getResource("META-INF/xml-resources/SimpleServiceService.wsdl");
        QName qname = new QName("http://service.simple.com/", "SimpleServiceService");
        SimpleServiceService service = new SimpleServiceService(wsdlUrl, qname);
        port = service.getSimpleServicePort();
        BindingProvider provider = (BindingProvider) port;
        provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:7001/SimpleServiceService");
        //port.empReturn("Rahul");
        //Asynchronous Callback Mechanism
        //callBack();

        //Polling Mechanism
        polling();
     
    }

    public static void callBack() {
        try {

            // TODO initialize WS operation arguments here
            java.lang.String name = "Rahul";
            javax.xml.ws.AsyncHandler<com.simple.service.TestOperationResponse> asyncHandler
                    = new javax.xml.ws.AsyncHandler<com.simple.service.TestOperationResponse>() {
                        public void handleResponse(javax.xml.ws.Response<com.simple.service.TestOperationResponse> response) {
                            try {
                                // TODO process asynchronous response here
                                System.err.println("Result = " + response.get().getFullName());
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                // TODO handle exception
                            }
                        }
                    };
            TestOperation oper = new TestOperation();
            oper.setName("Rahul");
            java.util.concurrent.Future<? extends java.lang.Object> result = port.testOperationAsync(oper, "SampleHeader", asyncHandler);
            //port.testOperation(oper, "SampleHeader");
            System.out.println("This is after handler invocation");
//            while (!result.isDone()) {
//                // do something
//                System.out.println("Response not available");
//            }
//            System.out.println("Response is available "+result.isDone());
            //Sleeping the thread so that the main program doesn't get completed 
            //because once the main program ends the jvm gets closed and also the threads running inside it.
            Thread.sleep(20000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void polling() {

        try { // Call Web Service Operation(async. polling)
            java.lang.String name = "Rahul";
            // TODO process asynchronous response here
            TestOperation oper = new TestOperation();
            oper.setName("Rahul");
            javax.xml.ws.Response<com.simple.service.TestOperationResponse> resp = port.testOperationAsync(oper, "SampleHeader");

            //port.hello(name);
            System.out.println("This is after calling service");
            while (!resp.isDone()) {
                // do something
                //this block will be terminated once the response is available.
                System.out.println("inside while loop " + resp.isDone());
                Thread.sleep(100);
            }
            System.out.println("Result = " + ((TestOperationResponse) resp.get()).getFullName());
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }
}
