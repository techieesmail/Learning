/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.client;

import com.learn.core.transferobjects.Employee;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sanghvir
 */
public class MainClass {
    public static void main(String[] args) {
        Client client =  ClientBuilder.newClient();
        
        WebTarget target =  client.target("http://localhost:7001/Service/app/res");
        Employee e = new Employee();
        e.setId(123).setName("Rahul");
        Employee res = target.path("/json").
                request(MediaType.APPLICATION_JSON).put(Entity.json(e),Employee.class);
        
        System.out.println("The name is "+res.getName());
        
        Employee ee = target.path("/xml").request(MediaType.APPLICATION_JSON).get(Employee.class);
        System.out.println("The xml response is "+ee.getName());
    }
}
