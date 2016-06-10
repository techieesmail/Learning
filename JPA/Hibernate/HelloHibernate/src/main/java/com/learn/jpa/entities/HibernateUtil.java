/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.jpa.entities;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author sanghvir
 */
@Component
public class HibernateUtil {
    
    @Autowired
    private  SessionFactory sessionFactory;
    
//    public static SessionFactory getSessionFactory(){
//        return new HibernateUtil()
//    }
}
