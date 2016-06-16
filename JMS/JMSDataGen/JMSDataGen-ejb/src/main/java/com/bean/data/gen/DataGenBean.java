/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean.data.gen;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueSender;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicPublisher;
import javax.transaction.TransactionSynchronizationRegistry;

/**
 *
 * @author Family
 */
@Stateless
public class DataGenBean implements DataGenBeanRemote {

    @Resource(mappedName = "NiravCF")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "NiravQ")
    private Queue queue;

    @Resource(mappedName = "NiravTopic")
    private Topic topic;

    @Resource
    TransactionSynchronizationRegistry tsr;
    
    @Resource
    private SessionContext context;

    @Override
    public String insertData(String name, Double amount, String destination) {

        Connection connection = null;
        Session session = null;
        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            System.out.println("The status of transaction is " + tsr.getTransactionStatus());
            MessageProducer producer = null;
             TextMessage message = session.createTextMessage();
            message.setStringProperty("NAME", name);
            message.setText(String.valueOf(amount)+" Message is Sent via "+destination+" from "+name);
            if (destination.equalsIgnoreCase("queue")) {
                producer = session.createProducer(queue);
                QueueSender sender = (QueueSender)producer;
               
                message.setJMSPriority(6);
               //message.setJMSExpiration(20000);
                
                //System.out.println("In Queue after setting priority and expiration");
                sender.send(message, DeliveryMode.PERSISTENT, message.getJMSPriority(), message.getJMSExpiration());
                //throw new NullPointerException("Custom Exception");
            } else if (destination.equalsIgnoreCase("topic")) {
                System.out.println("Inside Topic");
                producer = session.createProducer(topic);
                TopicPublisher publisher = (TopicPublisher)producer;
                publisher.publish(message);
            }
           
            
            //session.commit();
            session.close();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            context.setRollbackOnly();
            try {
                session.rollback();
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
            return "failure";

        } finally {
            try {
                connection.close();
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }

    }

}
