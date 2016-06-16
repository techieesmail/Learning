/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.rest;

import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Family
 */
@Path("base")
//@Stateless
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of com.base.rest.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Response getXml() {
        //TODO return proper representation object
        Response.ResponseBuilder builder = Response.ok("Rahul");
       return builder.build();
           
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
    
//    @Path("service")
//    public String serviceLocate()
//    {
//        
//        return "Sir";
//        
//    }
    
//    @GET
//    public String getservice()
//    {
//       return "Sir from service" ;
//    }
    
//    @GET
//    //@Produces({MediaType.TEXT_PLAIN})
//    public Response getXml1() {
//        //TODO return proper representation object
//        Response.ResponseBuilder builder = Response.ok("Rahul second time");
//       return builder.build();
//           
//    }
}
