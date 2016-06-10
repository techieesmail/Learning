/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remote.ejb.rest;

import com.inter.remote.HelloRemoteInterface;
import com.shared.classes.SharedClass;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author SanghviR
 */
@Path("/basic")
public class BasicResource {

//@EJB(mappedName = )    
private HelloRemoteInterface remote;
    
    //@Resource
    UserTransaction transaction;
    
    
    @GET
    public Response getResponseFromEJB()throws Exception{
        Context c = new InitialContext();
        //System.out.println(c.list(""));
        //remote = (HelloRemoteInterface)c.lookup("java:global.com.learn.ejb_EJBs-ear_ear_1.0-SNAPSHOT.EJBs-ejb-1.0-SNAPSHOT.HelloBusinessImpl!com.inter.remote.HelloRemoteInterface");
        remote = (HelloRemoteInterface)c.lookup("adp:mt:comp/Hello#com.inter.remote.HelloRemoteInterface");
        remote.updateSharedI(40);
        SharedClass shared = remote.getSharedClass();
        System.out.println("The shared class hashcode in resource "+shared.hashCode());
        //remote.getExecClass();
        shared.printI();
        shared.exec();
        //TransactionManager transaction = (TransactionManager)c.lookup("javax.transaction.TransactionManager");
        //Transaction transaction = transactionManager.getTransaction();
        
        transaction = (UserTransaction)c.lookup("javax.transaction.UserTransaction");
        transaction.begin();
        remote.createConnections();
        //remote.insertRecordDB();
       // transaction.rollback();
        transaction.commit();
        remote.closeConnections();
        
        
        
        //multiple DBs
        remote.insertIntoMultipleDBs();
        
        return Response.ok(remote.sayHello("Rahul")).build();
    }
}
