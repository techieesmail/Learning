/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.provider;

import com.jaxb.rahul.Customer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Family
 */
@Provider
@Produces(MediaType.APPLICATION_XML)
public class CustomerMessageBodyWriter implements MessageBodyWriter<Customer> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
       return true;
    }

    @Override
    public long getSize(Customer t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
       return 2;
    }

    @Override
    public void writeTo(Customer t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
       
        System.out.println("The name is "+t.getName());
//        ObjectOutputStream obj = new ObjectOutputStream(entityStream);
//        obj.writeObject(t);
//        obj.flush();
//        obj.close();
        try{
        JAXBContext context = JAXBContext.newInstance(com.jaxb.rahul.Customer.class);
       // t.setName("Sachin");
        Marshaller ma = context.createMarshaller();
        ma.setProperty(ma.JAXB_FORMATTED_OUTPUT, true);
               //ma .marshal(t, new FileOutputStream(new File("E:\\Rahul\\Tuition\\xml\\customerGen1.xml")));
        ma .marshal(t, entityStream);
        ma.marshal(context, System.out);
        //entityStream.flush();
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Byye");
        }
        //entityStream.write(t.getPin());
    }
    
}
