/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package secureservicesclient;

import com.secure.service.handler.SamlHandler;
import com.secure.service.handler.x509Handler;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

/**
 *
 * @author Family
 */
public class SecureServicesClient {

    /**
     * @param args the command line arguments
     */
    
    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier() {
                    public boolean verify(String hostname,
                            javax.net.ssl.SSLSession sslSession) {
                        if (hostname.equals("localhost")) {
                            return true;
                        }
                        return false;
                    }
                });
        
        //SSL Configuration
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");
        System.setProperty("javax.net.ssl.trustStore", "D:\\Glassfish4.0\\glassfish-4.0\\glassfish\\domains\\domain1\\config\\cacerts.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        System.setProperty("javax.net.ssl.trustStoreFileBased", "true");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //userName("Rahul");
        
        //x509("Rahul");
        
        //asymmetric("Rahul");
        
        saml("Rahul");
    }

    private static String userName(java.lang.String name) {
        com.service.username.UserNameService_Service service = new com.service.username.UserNameService_Service();
        com.service.username.UserNameService port = service.getUserNameServicePort();
        
        return port.hello(name);
    }

    private static String x509(java.lang.String name) {
        
        
        
        
        com.x509.service.X509Service_Service service = new com.x509.service.X509Service_Service();
        com.x509.service.X509Service port = service.getX509ServicePort();
        BindingProvider provider = (BindingProvider)port;
        provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://localhost:8181/SecureServices/x509Service");
        List<Handler> ls = new ArrayList<Handler>();
        ls.add(new x509Handler());
        provider.getBinding().setHandlerChain(ls);
        return port.hello(name);
    }

    private static String asymmetric(java.lang.String name) {
        com.service.asymmetric.AsymmetricWebService_Service service = new com.service.asymmetric.AsymmetricWebService_Service();
        com.service.asymmetric.AsymmetricWebService port = service.getAsymmetricWebServicePort();
        return port.hello(name);
    }

    private static String saml(java.lang.String name) {
        com.service.saml.SamlService_Service service = new com.service.saml.SamlService_Service();
        com.service.saml.SamlService port = service.getSamlServicePort();
        BindingProvider provider = (BindingProvider)port;
        List<Handler> ls = new ArrayList<Handler>();
        ls.add(new SamlHandler());
        provider.getBinding().setHandlerChain(ls);
        return port.hello(name);
    }
    
}
