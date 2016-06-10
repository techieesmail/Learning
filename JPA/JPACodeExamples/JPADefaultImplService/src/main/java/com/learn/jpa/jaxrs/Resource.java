/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.jpa.jaxrs;

import com.learn.jpa.entities.Employee;
import com.learn.jpa.entities.EmployeeDetails;
import com.learn.jpa.entities.EmployeeDetails_;
import com.learn.jpa.entities.Employee_;
import com.learn.jpa.entities.JpaTable;
import com.learn.jpa.jaxrs.messagebeans.JpaTableBean;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sanghvir
 */
@Path("/jpql")
@RequestScoped // Used for injecting CDI into Jax-rs
public class Resource {

    //@PersistenceContext(name = "defaultJPAImpl")
    @PersistenceContext(unitName = "H2JPA")
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Transactional
    public Response getData() {
        try {
//            TypedQuery<JpaTable> query = em.createQuery("select j from JpaTable j", JpaTable.class);
//           // TypedQuery<JpaTable> updateQuery = em.createQuery("update JpaTable j set j.teststring = 'JPQL Update' where j.pkcol=1 ", JpaTable.class);
//            TypedQuery<EmployeeDetails> joinQuery = em.createQuery("select d from EmployeeDetails d JOIN d.employee e ", EmployeeDetails.class);
//            
//            //int i = updateQuery.executeUpdate();
//            List<JpaTable> ls = query.getResultList();
//            EmployeeDetails details = joinQuery.getSingleResult();
//            System.err.println("The salary is " + details.getEmailid());
//            
//            //Find
//            JpaTable jpa =  em.find(JpaTable.class, new Long(5));
//            JpaTableBean bean  = new JpaTableBean();
//            bean.setPkcol(jpa.getPkcol());
//            bean.setTeststring(jpa.getTeststring());
            
            //Criteria
//            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//            CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
//            
            //Root using EmployeeDetails
//            Root<EmployeeDetails> ed = criteria.from(EmployeeDetails.class);
////            Join<EmployeeDetails,Employee> join = ed.join(EmployeeDetails_.employee, JoinType.INNER);
////            System.out.println("The predicate "+join.getOn());
//            criteria.select(ed.get(EmployeeDetails_.employee))
//                    .where(criteriaBuilder.equal(ed.get(EmployeeDetails_.employeeId), 1));
            
           
//            TypedQuery<Employee> etype = em.createQuery(criteria);
            
            //TypedQuery<Employee> etype = em.createQuery("select e from EmployeeDetails ed INNER JOIN ed.employee e",Employee.class);
            Employee employee = em.find(Employee.class, 1);
            //Employee employee = etype.getSingleResult();
            
            
            //
            
            
            return Response.ok(employee.getFirstName()).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.ok("Something went wrong ").build();
    }
}
