/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.jpa.restservice;

import com.learn.jpa.entities.JpaTable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sanghvir
 */
@Path("/basic")
//Since REST resource are request scopted by default. Explicitly mentioning request scope makes available for CDI
@RequestScoped
public class Resource {


    @PersistenceContext(unitName = "H2JPA")
    private EntityManager em;

//    @PersistenceUnit(unitName = "H2JPA")
//    private EntityManagerFactory emf;
    @javax.annotation.Resource(mappedName = "javax.transaction.UserTransaction")
    private UserTransaction tx;

    public Resource() {
//        try {
//            // em = Persistence.createEntityManagerFactory("H2JPA").createEntityManager();
//            Context c = new InitialContext();
//            tx = (UserTransaction) c.lookup("javax.transaction.UserTransaction");
//        } catch (NamingException ex) {
//            ex.printStackTrace();
//        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JpaTable getEntity() {
        JpaTable entity = em.find(JpaTable.class, 1);
        System.out.println("The value from entity " + entity.getTestString());
        return entity;
    }

    @GET
    @Path("/update")
    public Response updateEntity(@QueryParam("id") int jpaId) throws WebApplicationException {
        em.find(JpaTable.class, jpaId).setTestString("Update from rs resource ");
        return Response.ok("Successfully updated the resource").build();
    }

    @GET
    @Path("/create")
    @RequireTransaction
    public String updateEntity() throws WebApplicationException {
        try {

            for (int i = 0; i < 5; i++) {
                JpaTable j = new JpaTable();
                j.setTestString("TestString for " + i);
                em.persist(j);
            }

            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e);
        }

    }
}
