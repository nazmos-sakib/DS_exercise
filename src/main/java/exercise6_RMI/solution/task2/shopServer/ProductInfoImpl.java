package exercise6_RMI.solution.task2.shopServer;

import exercise6_RMI.solution.task2.shopInterface.Product;
import exercise6_RMI.solution.task2.shopInterface.ProductInfo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;



public class ProductInfoImpl  extends UnicastRemoteObject implements ProductInfo {

    public ProductInfoImpl() throws RemoteException {
    }

    public List<Product> findProducts(String searchString) {
        Persistence persistence = Persistence.getInstance();
        return persistence.findProducts(searchString);
    }

    public List<Product> findProductsByTitle(String searchString) {
        Persistence persistence = Persistence.getInstance();
        return persistence.findProductsByTitle(searchString);
    }

    public List<Product> findProductsByPerson(String searchString) {
        Persistence persistence = Persistence.getInstance();
        return persistence.findProductsByPerson(searchString);
    }

    public List<Product> findBooks(String searchString) {
        System.out.println("----------------"+searchString);
        Persistence persistence = Persistence.getInstance();
        return persistence.findBooks(searchString);
    }

    public List<Product> findBooksByTitle(String searchString) {
        Persistence persistence = Persistence.getInstance();
        return persistence.findBooksByTitle(searchString);
    }

    public List<Product> findBooksByPerson(String searchString) {
        Persistence persistence = Persistence.getInstance();
        return persistence.findBooksByPerson(searchString);
    }

    public List<Product> findFilms(String searchString) {
        Persistence persistence = Persistence.getInstance();
        return persistence.findFilms(searchString);
    }

    public List<Product> findFilmsByTitle(String searchString) {
        Persistence persistence = Persistence.getInstance();
        return persistence.findFilmsByTitle(searchString);
    }

    public List<Product> findFilmsByPerson(String searchString) {
        Persistence persistence = Persistence.getInstance();
        return persistence.findFilmsByPerson(searchString);
    }
}
