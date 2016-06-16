/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basicauthclient;

import com.service.BasicAuthSEI;
import com.service.SimpleBasicAuthService;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author Family
 */
public class BasicAuthClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
  
 
  
        SimpleBasicAuthService service = new SimpleBasicAuthService();
        BasicAuthSEI sei = service.getTestPort();        
        BindingProvider provider = (BindingProvider)sei;
        provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:2000/BasicAuthenticationWebService/SimpleBasicAuthService");
        provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "TestUser");
        provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "Testpass8");
        
        sei.getName("Rahul");
    }
    
    
}

