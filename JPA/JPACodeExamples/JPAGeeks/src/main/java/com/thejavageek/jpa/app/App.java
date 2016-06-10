/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thejavageek.jpa.app;

import com.thejavageek.jpa.entities.Employee;
import com.thejavageek.jpa.entities.Project;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author SanghviR
 */
public class App {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAGeeks");
        EntityManager entityManager = factory.createEntityManager();

        try {

            App app = new App();
            app.associations(entityManager);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            entityManager.close();
            factory.close();
        }

    }

    private void associations(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        
        Employee e = em.find(Employee.class, 1);
        
        System.out.println("The first name is "+e.getFirstname());
        e.setFirstname("Apeksha");
        em.remove(e);
//        Employee e = new Employee();
//        e.setFirstname("Rahul");
//
//        Project p = new Project();
//        p.setName("Electrical");
////        p.setIdproject(1);
////        em.merge(p);
//        List<Project> ls = new ArrayList<>();
//        ls.add(p);
//
//        e.setProjects(ls);
//        em.persist(e);

        transaction.commit();

    }

}


//Relationships finish with “One” will be EAGERly fetched: @OneToOne and @ManyToOne.
//Relationships finish with “Many” will be LAZYly fetched: @OneToMany and @ManyToMany