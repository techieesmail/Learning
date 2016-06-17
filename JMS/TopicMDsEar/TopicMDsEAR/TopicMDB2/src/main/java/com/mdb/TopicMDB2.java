/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mdb;

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
@MessageDriven(mappedName = "SampleJMSTopic", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class TopicMDB2 implements MessageListener {
    
    public TopicMDB2() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("In message listner of topic");
            TextMessage txt = (TextMessage)message;
            System.out.println(txt.getText()+" "+this.getClass().getName());
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
    
}
