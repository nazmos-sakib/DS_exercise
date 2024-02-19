package exercise8_9_JMS.solution.task1_ActiveMQ.hello;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;

public class HolaActiveMQ {
    public static void main(String[] args) {

        try {
            ActiveMQConnectionFactory connectionFactory
                = new ActiveMQConnectionFactory("tcp://localhost:61616"); //ActiveMQConnection.DEFAULT_BROKER_URL
            Connection connection = connectionFactory.createConnection();
            connection.start();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
