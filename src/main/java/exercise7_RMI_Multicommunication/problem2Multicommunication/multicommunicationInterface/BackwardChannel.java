package exercise7_RMI_Multicommunication.problem2Multicommunication.multicommunicationInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BackwardChannel extends Remote{
    void sendMessage(String message) throws RemoteException;
}
