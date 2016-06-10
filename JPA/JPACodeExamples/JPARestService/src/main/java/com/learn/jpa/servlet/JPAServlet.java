/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.jpa.servlet;

import com.learn.jpa.entities.JpaTable;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author sanghvir
 */
@WebServlet("/jpaserv")
public class JPAServlet extends HttpServlet {

    //@PersistenceContext(unitName = "H2JPA")
    private EntityManager em;

    @PersistenceUnit(unitName = "H2JPA")
    private EntityManagerFactory emf;

    @javax.annotation.Resource(mappedName = "javax.transaction.UserTransaction")
    private UserTransaction tx;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hey for debug");
        em = emf.createEntityManager();
        try {
            for (int i = 0; i < 5; i++) {
                //tx.begin();
                JpaTable j = new JpaTable();
                j.setTestString("TestString for " + i);
                 System.out.println(tx.getStatus());
                em.persist(j);
               
                //tx.commit();
                //em.flush();
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

    /*
    
STATUS_ACTIVE	0

STATUS_COMMITTED 3

STATUS_COMMITTING 8

STATUS_MARKED_ROLLBACK	1
STATUS_NO_TRANSACTION	6

STATUS_PREPARED	2

STATUS_PREPARING 7

STATUS_ROLLEDBACK 4

STATUS_ROLLING_BACK 9

STATUS_UNKNOWN	5
    
    
    
    
    
     */
}
