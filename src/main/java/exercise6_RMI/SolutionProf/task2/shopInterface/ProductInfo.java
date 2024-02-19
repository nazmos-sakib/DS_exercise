package exercise6_RMI.SolutionProf.task2.shopInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ProductInfo extends Remote{
    List<Product> findBooks(String searchString) throws RemoteException;
    List<Product> findBooksByTitle(String searchString) throws RemoteException;
    List<Product> findBooksByPerson(String searchString) throws RemoteException;
    List<Product> findFilms(String searchString) throws RemoteException;
    List<Product> findFilmsByTitle(String searchString) throws RemoteException;
    List<Product> findFilmsByPerson(String searchString) throws RemoteException;
}
