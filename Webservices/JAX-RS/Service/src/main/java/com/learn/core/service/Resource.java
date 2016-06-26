/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.service;

import com.learn.core.transferobjects.Employee;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sanghvir
 */
@Path("/res")
public class Resource {
    
    @JSONStereotype
    @Path("/json")
    @PUT
    public Response getJSONResponse(Employee input){
        System.out.println("The employee name from input is "+input.getName());
        Employee e =  new Employee();
        e.setName("Nandeesh").setId(125);
        return Response.ok(e).build();
    }
    
    @XMLStereoType
    @Path("/xml")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @GET
    public Employee getEmployee(){
        Employee e =  new Employee();
        e.setName("Nandeesh").setId(125);
        return e;
    }
}
