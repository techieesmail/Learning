/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package durablestandaloneclient;


import java.util.Hashtable;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.Context;
import weblogic.jms.client.JMSContext;
import weblogic.jndi.WLInitialContextFactory;

/**
 *
 * @author Family
 */
public class DurableStandaloneClient {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
       try{
           Hashtable hastable = new Hashtable();
            hastable.put(Context.PROVIDER_URL, "t3://localhost:7001");
            topicConsumer(hastable);
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    
    public static void topicConsumer(Hashtable hastable)throws Exception{
        int i=0;
        Context jndiContext = new WLInitialContextFactory().getInitialContext(hastable);
        ConnectionFactory factory = (ConnectionFactory) jndiContext.lookup("SampleConnectionFactory");
       
        Connection conn = factory.createConnection();
      
        conn.setClientID("DurableID11");
        Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
         Topic topic = (Topic) jndiContext.lookup("SampleJMSTopic");
         
         
         MessageConsumer consumer = sess.createDurableSubscriber(topic,"SharedSubscription11");
        //Durable Consumer with filtering
        //MessageConsumer consumer = sess.createDurableSubscriber(topic,"DurableSubscription","NAME='Rahul'",false);
       
        
        
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
