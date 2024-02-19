package exercise8_9_JMS.SolutionProf.producerconsumer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer{ private final int numberOfSentences;private final String nounQueue;private final String verbQueue;
    public Consumer(int numberOfSentences, String nounQueue, String verbQueue) {
        this.numberOfSentences = numberOfSentences;
        this.nounQueue = nounQueue;
        this.verbQueue = verbQueue;
    }
    public void outputSentences() {Connection connection = null;
        try {
            ActiveMQConnectionFactory connectionFactory
                    = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            Destination nounDestination = session.createQueue(nounQueue);
            Destination verbDestination = session.createQueue(verbQueue);
            MessageConsumer nounConsumer = session.createConsumer(nounDestination);
            MessageConsumer verbConsumer = session.createConsumer(verbDestination);
            connection.start();
            for (int i = 0; i < numberOfSentences; i++) {
                Message msg = nounConsumer.receive();
                String noun1 = ((TextMessage) msg).getText();
                msg = nounConsumer.receive();
                String noun2 = ((TextMessage) msg).getText();
                msg = verbConsumer.receive();
                String verb = ((TextMessage) msg).getText();
                System.out.println("The " + noun1 + " " + verb + " the " + noun2 + ".");
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
