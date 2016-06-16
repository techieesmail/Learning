/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client;

import java.util.Hashtable;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import weblogic.jndi.WLInitialContextFactory;

/**
 *
 * @author Family
 */
public class StandaloneClient {

    /**
     * @param args the command line arguments
     */
 

    public static void main(String[] args) throws Exception {
        try {
            Hashtable hastable = new Hashtable();
            hastable.put(Context.PROVIDER_URL, "t3://localhost:4001");
//        hastable.put(Context.SECURITY_PRINCIPAL, "weblogic");
//        hastable.put(Context.SECURITY_CREDENTIALS, "Weblogic$87");
            
            queueConsumer(hastable);
            //topicConsumer(hastable);

            // System.exit(0);
        } catch (Exception e) {
            System.exit(0);
        }
        
    }
    
    public static void queueConsumer(Hashtable hashtable) throws Exception {
        int i=0;
        Context jndiContext = new WLInitialContextFactory().getInitialContext(hashtable);
        ConnectionFactory factory = (ConnectionFactory) jndiContext.lookup("NiravCF");
        Queue queue = (Queue) jndiContext.lookup("NiravQ");
        Connection conn = factory.createConnection();
        Session sess = conn.createSession(false, Session.CLIENT_ACKNOWLEDGE);

         MessageConsumer consumer = sess.createConsumer(queue);
        //Filtering Message
        //MessageConsumer consumer = sess.createConsumer(queue, "NAME='Nirav'");
        conn.start();
        
        while (true) {
            TextMessage message = (TextMessage) consumer.receive();
            i++;
            System.out.println("The message received is " + message.getText() +" "+i);
            message.acknowledge();
            
            if (i == 15) {
                consumer.close();
                conn.stop();
                conn.close();
                return;
            }
        }
    }
    
    public static void topicConsumer(Hashtable hastable)throws Exception{
        int i=0;
        Context jndiContext = new WLInitialContextFactory().getInitialContext(hastable);
        ConnectionFactory factory = (ConnectionFactory) jndiContext.lookup("SampleConnectionFactory");
       
        Connection conn = factory.createConnection();
        Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
         Topic topic = (Topic) jndiContext.lookup("SampleJMSTopic");
        MessageConsumer consumer = sess.createConsumer(topic);
        
        conn.start();
        
        while (true) {
            
            //Timeout setting
            //TextMessage message = (TextMessage) consumer.receive(10000);
            
            
            TextMessage message = (TextMessage) consumer.receive();
            
            System.out.println("The message received is " + message.getText());
            i++;
            if (i == 2) {
                consumer.close();
                conn.stop();
                conn.close();
                return;
            }
        }
    }
}
