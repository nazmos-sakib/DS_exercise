package exercise7_RMI_Multicommunication.problem2Multicommunication.multicommunicationInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Communication extends Remote{
    void connect(String name, BackwardChannel backchannel) throws RemoteException;
    void disconnect(String name) throws RemoteException;
}
