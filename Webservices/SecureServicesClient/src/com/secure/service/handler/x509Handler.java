/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.secure.service.handler;

import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author Family
 */
public class x509Handler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
       return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        try {
            SOAPMessage message = context.getMessage();
            message.writeTo(System.out);
            System.out.println();
            System.out.println("---------------------------------");
        } catch (Exception e) {
            System.out.println("This is exception execution from message");
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        try {
            SOAPMessage message = context.getMessage();
            message.writeTo(System.out);
            System.out.println();
            System.out.println("---------------------------------");
        } catch (Exception e) {
            System.out.println("This is exception execution from fault");
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }

}
