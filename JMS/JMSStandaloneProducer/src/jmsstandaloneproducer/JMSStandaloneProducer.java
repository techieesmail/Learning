/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmsstandaloneproducer;

import java.util.Hashtable;
import javax.jms.Queue;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.QueueSender;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import weblogic.jndi.WLInitialContextFactory;

/**
 *
 * @author Family
 */
public class JMSStandaloneProducer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        Hashtable hashtable = new Hashtable();
        hashtable.put(Context.PROVIDER_URL, "t3://localhost:7001");
        
        //Needed for secure modules
//        hashtable.put(Context.SECURITY_PRINCIPAL, "TestUser");
//        hashtable.put(Context.SECURITY_CREDENTIALS, "Testpass87");
        Context jndiContext = new WLInitialContextFactory().getInitialContext(hashtable);
        ConnectionFactory factory = (ConnectionFactory) jndiContext.lookup("SampleConnectionFactory");
        Queue queue = (Queue) jndiContext.lookup("SampleJMSQueue");

        //Secure Data
//        ConnectionFactory factory = (ConnectionFactory) jndiContext.lookup("SecureConnectionFactory");
//        Queue queue = (Queue) jndiContext.lookup("SecureQueue");

        Connection conn = factory.createConnection();
        Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        QueueSender producer = (QueueSender) sess.createProducer(queue);
        for (int i = 0; i <= 25; i++) {
            TextMessage message = sess.createTextMessage("This is standalone producer");
            
            //secure Message
            //TextMessage message = sess.createTextMessage("This is secured message");
            message.setBooleanProperty("standalone", true);
            producer.send(message);
        }

        sess.close();
        conn.close();
    }

}
