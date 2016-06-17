/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mdb.durable;

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
//@MessageDriven(name ="DurableSubscriber",mappedName = "SampleJMSTopic", activationConfig = {
//    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
//    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "durable"),
//    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "DurableMDBTopicID"),
//    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "DurableMDBTopicSubscriber")
//})

@MessageDriven(mappedName = "SampleJMSTopic", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "durable"),
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "DurableMDBTopicID"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "DurableMDBTopicSubscriber")
})
public class DurableMDBTopic implements MessageListener {
    
    public DurableMDBTopic() {
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
