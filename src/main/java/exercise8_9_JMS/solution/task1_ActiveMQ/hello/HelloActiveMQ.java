package exercise8_9_JMS.solution.task1_ActiveMQ.hello;
 
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HelloActiveMQ {
 
    public static void main(String[] args){
 
        try {
            String queueName = "Hello";
            ActiveMQConnectionFactory connectionFactory
                    = new ActiveMQConnectionFactory("tcp://localhost:61616"); //ActiveMQConnection.DEFAULT_BROKER_URL
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(queueName);
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage("Hello world!");
            producer.send(message);
            connection.close();

            connection = connectionFactory.createConnection();
            session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue(queueName);
            MessageConsumer consumer = session.createConsumer(destination);
            connection.start();
            message = (TextMessage)consumer.receive(1000);
            System.out.println(message.getText());
            connection.close();
        } catch (JMSException ex) {
            Logger.getLogger(HelloActiveMQ.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
}

