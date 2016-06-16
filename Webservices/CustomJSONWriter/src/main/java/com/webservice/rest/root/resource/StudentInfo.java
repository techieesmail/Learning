/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.rest.root.resource;

import com.webservice.rest.data.object.Course;
import com.webservice.rest.data.object.DefaultJSON;
import com.webservice.rest.data.object.Employee;
import com.webservice.rest.data.object.Student;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Family
 */
@Path("/studentInfo")
public class StudentInfo {

    @Context
    private HttpServletRequest httpRequest;
    @Path("/{studentId}")
    public Student getStudent(@PathParam("studentId") int id ) {

        Student student = new Student();
        List<Course> courseList = student.getCourses();
        Course course = null;
        if (id == 1) {
            student.setName("Rajesh");
            student.setAge(20);
            course = new Course();
            course.setCourseName("Java");
            course.setDuration("3");
            courseList.add(course);
        } else {
            System.out.println("The request code is "+httpRequest);
            student.setName("Common");
            student.setAge(20);
            course = new Course();
            course.setCourseName("CommonCourse");
            course.setDuration("3");
            courseList.add(course);
        }
        return student;

    }

    @Path("/emp")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Employee getEmployee() {
        Employee e = new Employee();
        e.setId(100);
        e.setName("Rahul");
        return e;
        
    }
    
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public DefaultJSON defaultJSON(){
        DefaultJSON j = new DefaultJSON();
        j.setId(111);
        j.setName("default");
        return j;
    }

}
