package com.rahul.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jaxb.rahul.Customer;
import javax.ws.rs.core.Response;

@Path("/xml/customer")
public class XMLService {

	@GET
	@Path("/{pin}")
	@Produces(MediaType.APPLICATION_XML)
	public Customer getCustomerInXML(@PathParam("pin") int pin) {

            System.out.println("The pin got is "+pin);
		Customer customer = new Customer();
		customer.setName("Vara");
		customer.setPin(pin);
                
               //Response.ResponseBuilder builder =  Response.ok(customer);

		//return builder.build();
               
               return customer;

	}
        
    @GET
    public String getservice()
    {
       return "Sir from service" ;
    }

}