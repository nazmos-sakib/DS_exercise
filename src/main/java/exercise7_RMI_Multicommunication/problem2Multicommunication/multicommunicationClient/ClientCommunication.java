package exercise7_RMI_Multicommunication.problem2Multicommunication.multicommunicationClient;


import exercise7_RMI_Multicommunication.problem2Multicommunication.multicommunicationInterface.BackwardChannel;
import exercise7_RMI_Multicommunication.problem2Multicommunication.multicommunicationInterface.Communication;

import java.rmi.Naming;

public class ClientCommunication {
    private String username;
    private BackwardChannel backwardChannel;
    private Communication communication;

    public void connect(String username, ClientCommunicationUI clientCommunicationUI) {
        this.username = username;
        try {
            this.communication = (Communication) Naming.lookup("//localhost:1090/Communication");
            this.backwardChannel = new BackwardChannelImpl(clientCommunicationUI);
            this.communication.connect(username, backwardChannel);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void disconnect() {
        try {
            this.communication.disconnect(username);
        } catch (Exception e){
            e.printStackTrace();
        }
        this.username = null;
        this.communication = null;
        this.backwardChannel = null;
    }
}
