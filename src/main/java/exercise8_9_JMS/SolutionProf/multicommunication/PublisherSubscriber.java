package exercise8_9_JMS.SolutionProf.multicommunication;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PublisherSubscriber { private String username;private Connection connection;private Session session;
    private Topic topic;private MessageProducer messageProducer;private MessageConsumer messageConsumer;
    public void connect(String topicName, String username, ClientCommunicationUI clientCommunicationUI) {
        try {
            this.username = username;
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                    ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            topic = session.createTopic(topicName);
            messageProducer = session.createProducer(topic);
            TextMessage textMessage = session.createTextMessage(username + " connected.");
            messageProducer.send(textMessage);
            messageConsumer = session.createConsumer(topic);
            MessageListener listener = new ClientListener(clientCommunicationUI);
            messageConsumer.setMessageListener(listener);
            connection.start();
        } catch (JMSException ex) {
            //Logger.getLogger(topic.Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }}
    public void disconnect() {
        try {
            messageConsumer.setMessageListener(null);
            TextMessage textMessage = session.createTextMessage(username + " disconnected.");
            messageProducer.send(textMessage);
        } catch (JMSException ex) {
            Logger.getLogger(PublisherSubscriber.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (JMSException ex) {
                    Logger.getLogger(PublisherSubscriber.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
