/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jms.producer.bean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author Family
 */
@Stateless
public class JMSProducerBean {
    
    @Resource(name = "SampleConnectionFactory")
    private  ConnectionFactory connectionFactory;
    
    @Resource(name = "SampleJMSQueue")
    private  Queue queue;

    public JMSProducerBean() {
        
       
        
    }
    
    @PostConstruct
    public void connInitialize()
    {
         try{
            
            Connection conn = connectionFactory.createConnection();
            Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = sess.createProducer(queue);
            TextMessage message = sess.createTextMessage("This is a simple JMS producer");
            producer.send(message);
            conn.close();
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
