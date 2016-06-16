/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.secure.mdb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.RunAs;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Family
 */
@MessageDriven(mappedName = "SecureQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
@RunAs("Administrators")
public class secureMDB implements MessageListener {
    
    public secureMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("The message received is "+((TextMessage)message).getText());
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
    
}
