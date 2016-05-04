/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author SanghviR
 */
@Path("basic")
public class BasicController {
    
    @Context
    private SecurityContext context;
    
    @GET
    public Response sentResponseAfterAuth(){
        Response r = Response.ok("You passed security").build();
        System.out.println("The context is "+context.getUserPrincipal().getName());
        return r;
    }
}
