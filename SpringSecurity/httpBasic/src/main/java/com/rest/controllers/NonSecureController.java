/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author SanghviR
 */
@Path("/nonBasic")
public class NonSecureController {
    
    @GET
    public Response sentResponseAfterAuth(){
        Response r = Response.ok("You are in non secure controller").build();
        return r;
    }
}
