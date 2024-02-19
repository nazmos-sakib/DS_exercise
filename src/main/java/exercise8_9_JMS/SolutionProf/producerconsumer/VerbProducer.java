package exercise8_9_JMS.SolutionProf.producerconsumer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VerbProducer { private final String[] verbs = {"sees", "follows", "likes", "ignores"};
    private final int numberOfElements;private final String queueName;
    public VerbProducer(int numberOfElements, String queueName) {
        this.numberOfElements = numberOfElements;
        this.queueName = queueName;
    }
    public void send() {
        Random random = new Random();
        Connection connection = null;
        try {
            ActiveMQConnectionFactory connectionFactory
                    = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(queueName);
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            for (int i = 0; i < numberOfElements; i++) {
                int index = random.nextInt(verbs.length);
                TextMessage msg = session.createTextMessage(verbs[index]);
                producer.send(msg);
            }
        } catch (JMSException ex) {
            Logger.getLogger(NounProducer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException ex) {
                    Logger.getLogger(VerbProducer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
}
