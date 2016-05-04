/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remote.ejb.rest;

import com.inter.remote.HelloRemoteInterface;
import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author SanghviR
 */
@Path("/basic")
public class BasicResource {

    private HelloRemoteInterface remote;
    
    @GET
    public Response getResponseFromEJB()throws Exception{
        Context c = new InitialContext();
        System.out.println(c.list(""));
        //remote = (HelloRemoteInterface)c.lookup("java:global.com.learn.ejb_EJBs-ear_ear_1.0-SNAPSHOT.EJBs-ejb-1.0-SNAPSHOT.HelloBusinessImpl!com.inter.remote.HelloRemoteInterface");
        remote = (HelloRemoteInterface)c.lookup("adp:mt:comp/Hello#com.inter.remote.HelloRemoteInterface");
        //System.out.println("The remote is "+remote);
        remote.updateSharedI(40);
        remote.getSharedClass().printI();
        return Response.ok(remote.sayHello("Rahul")).build();
    }
}
