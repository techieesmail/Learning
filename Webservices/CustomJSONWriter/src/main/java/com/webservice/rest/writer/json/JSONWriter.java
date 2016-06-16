/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webservice.rest.writer.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webservice.rest.data.object.Course;
import com.webservice.rest.data.object.Student;
import com.webservice.rest.data.object.StudentAddress;
import com.webservice.rest.data.object.StudentSuper;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;


/**
 *
 * @author Family
 */

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JSONWriter implements MessageBodyWriter<StudentSuper> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        System.out.println("The type is "+type);
        System.out.println("The generic type is "+genericType);
        Class[] interfaces = type.getInterfaces();
        if(interfaces!=null && interfaces.length > 0){
            String interfaceName = type.getInterfaces()[0].getName();
            System.out.println("The super class name "+interfaceName);
            if(interfaceName.equalsIgnoreCase(StudentSuper.class.getName()))
            return true;
        else
            return false;
        }else{
            System.out.println("The object is not implementing marker studentsuper ");
            return false;
        }
        
        
    }

    @Override
    public long getSize(StudentSuper t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(StudentSuper t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        ObjectMapper mapper = new ObjectMapper();
        if(t instanceof Student){
            System.out.println("Inside Student json writer");
            //using jsop api from javaee 7
            Student student = (Student)t;
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            objectBuilder.add("personName", student.getName());
            
            //getting the list of courses
            List<Course> ls = student.getCourses();
            Iterator<Course> iter = ls.iterator();
            JsonArrayBuilder courseArray = Json.createArrayBuilder();
            while(iter.hasNext()){
                Course course = iter.next();
                JsonObjectBuilder courseObj = Json.createObjectBuilder();
                courseObj.add("coursename", course.getCourseName()).add("duration", course.getDuration());
                courseArray.add(courseObj);
            }
            objectBuilder.add("courseList", courseArray);
            JsonObject object = objectBuilder.build();
            
            //Writing the json
            JsonWriter writer = Json.createWriter(entityStream);
            writer.writeObject(object);
            writer.close();
            
//             try (JsonWriter jsonWriter = Json.createWriter(entityStream)) {
//            jsonWriter.writeObject(object);
//        }
            
        }else if(t instanceof StudentAddress){
            System.out.println("In the address json");
            //using jackson for generation json
            StudentAddress address = (StudentAddress)t;
            mapper.writeValue(entityStream, address);
        }
        
    }
    
}
