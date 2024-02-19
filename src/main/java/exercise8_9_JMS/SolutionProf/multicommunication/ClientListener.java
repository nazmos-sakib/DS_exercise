package exercise8_9_JMS.SolutionProf.multicommunication;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientListener implements MessageListener
{
    private ClientCommunicationUI clientCommunicationUI;
    public ClientListener(ClientCommunicationUI clientCommunicationUI){
        this.clientCommunicationUI = clientCommunicationUI;
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage){
            try {
                TextMessage msg = (TextMessage) message;            
                clientCommunicationUI.addMessage(msg.getText());
            } catch (JMSException ex) {
                Logger.getLogger(ClientListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            clientCommunicationUI.addMessage("Unknown message type received.");
        }
    }
    
}
