/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mdb.ui.listner;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueSender;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.transaction.SystemException;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.UserTransaction;

/**
 *
 * @author Family
 */
@MessageDriven(name = "MDB_BMT",mappedName = "SampleJMSQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "messageSelector",propertyValue = "NAME='UI'")
})
@TransactionManagement(TransactionManagementType.BEAN)
public class BMTUIListner implements MessageListener {
    
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
    
    @Resource     
    private UserTransaction ut;
    
    public BMTUIListner() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("The status of transaction is " + tsr.getTransactionStatus());
            TextMessage txt = (TextMessage)message;
            System.out.println(txt.getText()+" "+this.getClass().getName());
            ut.begin();
            //pushing the message to EmailQ
            Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
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
          // throw new JMSException("Custom Exception");
            int i = 0;
            long j = 10/i;
            ut.commit();
            //session.commit();
            
        } catch (Exception ex) {
            System.out.println("Rolling back the transaction "+ex.getMessage());
            try {
                ut.rollback();
            } catch (IllegalStateException ex1) {
                Logger.getLogger(BMTUIListner.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (SecurityException ex1) {
                Logger.getLogger(BMTUIListner.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (SystemException ex1) {
                Logger.getLogger(BMTUIListner.class.getName()).log(Level.SEVERE, null, ex1);
            }
            //context.setRollbackOnly();
            //ex.printStackTrace();
        }
    }
    
    
    //LifeCycle Methods
    @PostConstruct
    public void onPostConstruct(){
        try {
            System.out.println("Inside post construct");
            connection = connectionFactory.createConnection();
        } catch (JMSException ex) {
            System.out.println("This exception is coming from on postConstruct");
            ex.printStackTrace();
        }
    }
    
    @PreDestroy
    public void onPreDestroy(){
        try {
            System.out.println("Inside pre destroy");
            connection.close();
        } catch (JMSException ex) {
           System.out.println("This exception is coming from preDestroy");
            ex.printStackTrace();
        }
    }
    
}
