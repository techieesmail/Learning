/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mdb.ui.listner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueSender;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.transaction.TransactionSynchronizationRegistry;

/**
 *
 * @author Family
 */
@MessageDriven(mappedName = "SampleJMSQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "messageSelector",propertyValue = "NAME='UI'")
})
public class UIListner implements MessageListener {
    
    @Resource(mappedName = "BankingConnectionFactory")
    private ConnectionFactory connectionFactory;
    private Connection connection;
    
    @Resource
    private MessageDrivenContext context;
    
    @Resource(mappedName = "EmailQueue")
    private Queue emailQ;
    
    @Resource(mappedName = "SMSQueue")
    private Queue smsQ;
     
    @Resource
    TransactionSynchronizationRegistry tsr;
    
    /**
     *
     */
    public UIListner() {
    }
    
    /**
     *
     * @param message
     */
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("The status of transaction is " + tsr.getTransactionStatus());
            TextMessage txt = (TextMessage)message;
            System.out.println(txt.getText()+" "+this.getClass().getName());
            
            //pushing the message to EmailQ
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            QueueSender emailSender = (QueueSender)session.createProducer(emailQ);
            TextMessage emailMessage = session.createTextMessage();
            emailMessage.setText("Email is sent with Message "+txt.getText());
            System.out.println("Email sent");
            emailMessage.setJMSType("email");
            emailSender.send(emailMessage);
            //session.commit();
            //pushing the message to SMSQ
            
            
            QueueSender smsSender = (QueueSender)session.createProducer(smsQ);
            TextMessage smsMessage = session.createTextMessage();
            smsMessage.setText("SMS is sent with Message "+txt.getText());
            System.out.println("SMS sent");
            smsMessage.setJMSType("sms");
            smsSender.send(smsMessage);
            
            //throwing Exception
           //throw new JMSException("Custom Exception");
            //session.commit();
            
        } catch (JMSException ex) {
//            System.out.println("Rolling back the transaction");
            context.setRollbackOnly();
//            ex.printStackTrace();
        }
    }
    
    
    //LifeCycle Methods

    /**
     *
     */
        @PostConstruct
    public void onPostConstruct(){
        try {
            System.out.println("The bean is constructed");
            connection = connectionFactory.createConnection();
        } catch (JMSException ex) {
//            System.out.println("This exception is coming from on postConstruct");
//            ex.printStackTrace();
        }
    }
    
    /**
     *
     */
    @PreDestroy
    public void onPreDestroy(){
        try {
            System.out.println("Just Before destroying the bean");
            connection.close();
        } catch (JMSException ex) {
           System.out.println("This exception is coming from preDestroy");
            ex.printStackTrace();
        }
    }
    
}
