package exercise6_RMI.solution.task2.shopServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ProductServer {
    public static void main(String[] args) {
        try {
            Registry r = LocateRegistry.createRegistry(1099);
            r.rebind("ProductInfo", new ProductInfoImpl());
            System.out.println("Server is connected and ready for operation.");
        } catch (RemoteException e) {
            System.out.println("Server not connected: " + e);
            e.printStackTrace();
        }
    }
    
}
