/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.rest.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 *  USAGE:
 * <pre>
 *        NewJerseyClient client = new NewJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Family
 */
public class NewJerseyClient {
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/BasicRest/webresources";

    public NewJerseyClient() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("base");
    }

    public String getXml() throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
    }

    public void putXml(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(requestEntity);
    }

    public void close() {
        client.destroy();
    }
    
    public static void main(String args[])
    {
        NewJerseyClient c = new NewJerseyClient();
        System.out.println("The return value is "+c.getXml());
    }
    
}
