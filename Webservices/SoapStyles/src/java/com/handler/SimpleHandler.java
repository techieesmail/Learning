/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.MimeHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author Family
 */
public class SimpleHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
//        Iterator<MimeHeader> header = context.getMessage().getMimeHeaders().getAllHeaders();
//        
//        while(header.hasNext())
//        {
//            System.out.println("The headers are "+header);
//        }
        
    // System.out.println("The headers are "+SOAPMessageContext.HTTP_REQUEST_HEADERS);
                
        System.out.println("This is handle Message called "+context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY));
        return false;//To change body of generated methods, choose Tools | Templates.
    }
    
  
    @Override
    public boolean handleFault(SOAPMessageContext context) {
        System.out.println("In handle fault"); //To change body of generated methods, choose Tools | Templates.
        return true;
    }

    @Override
    public void close(MessageContext context) {
        System.out.println("In close"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
