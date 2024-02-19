package exercise7_RMI_Multicommunication.problem2Multicommunication.multicommunicationServer;

import exercise7_RMI_Multicommunication.problem2Multicommunication.multicommunicationInterface.BackwardChannel;
import exercise7_RMI_Multicommunication.problem2Multicommunication.multicommunicationInterface.Communication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class CommunicationImpl extends UnicastRemoteObject implements Communication {
    private final Map<String, BackwardChannel> channelMap;
    public CommunicationImpl() throws RemoteException {
        super();
        channelMap = new HashMap<>();
    }
    @Override
    public void connect(String name, BackwardChannel channel) throws RemoteException{
        sendMessageToAll(name+" is now connected");
        channelMap.put(name,channel);
    }
    @Override
    public void disconnect(String name) throws RemoteException{
        sendMessageToAll(name+" is now disconnected");
        channelMap.remove(name);
    }
    private void sendMessageToAll(String message) {
        channelMap.forEach((k,b)->{
            try {
                b.sendMessage(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
    }
    
}
