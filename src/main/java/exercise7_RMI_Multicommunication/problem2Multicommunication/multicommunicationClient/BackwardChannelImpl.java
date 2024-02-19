package exercise7_RMI_Multicommunication.problem2Multicommunication.multicommunicationClient;

import exercise7_RMI_Multicommunication.problem2Multicommunication.multicommunicationInterface.BackwardChannel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BackwardChannelImpl extends UnicastRemoteObject implements BackwardChannel {
    private ClientCommunicationUI clientCommunicationUI;
    public BackwardChannelImpl(ClientCommunicationUI clientCommunicationUI) throws RemoteException {
        super();
        this.clientCommunicationUI = clientCommunicationUI;
    }
    @Override
    public void sendMessage(String message) throws RemoteException {
        clientCommunicationUI.addMessage(message);
    }
}
