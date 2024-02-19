package exercise7_RMI_Multicommunication.problem1WordGuessing.wordGuessingServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class WordguessingServer {
    public static void main(String[] args)  {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("wordGuessingFactory", new WordguessingFactoryImpl());
            System.out.println("server is running");
        }catch (RemoteException e){
            e.printStackTrace();
        }
    }
}
    