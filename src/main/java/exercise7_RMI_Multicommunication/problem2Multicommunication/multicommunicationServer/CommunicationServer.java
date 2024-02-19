package exercise7_RMI_Multicommunication.problem2Multicommunication.multicommunicationServer;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CommunicationServer {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1090);
            registry.rebind("Communication", new CommunicationImpl());
            System.out.println("communication server is running");
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }

}
