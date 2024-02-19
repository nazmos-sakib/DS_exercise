package exercise6_RMI.SolutionProf.task2.shopClient;


import exercise6_RMI.solution.task2.shopInterface.Product;
import exercise6_RMI.solution.task2.shopInterface.ProductInfo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author neuhardt
 */
public class ProductInfoClient {
    private static final String ALL = "all";
    private static final String BOOK = "book";
    private static final String FILM = "film";
    private static final String TITLE = "by title";
    private static final String PERSON = "by person";

    public static List<Product> findProducts(String searchString, String searchCat, String productCat){
        List<Product> productList = null;
        try {
            ProductInfo productInfo = (ProductInfo) Naming.lookup("//localhost/ProductInfo");
            switch (productCat) {
                case BOOK:
                    switch (searchCat) {
                        case ALL:
                            productList = productInfo.findBooks(searchString);
                            break;
                        case TITLE:
                            productList = productInfo.findBooksByTitle(searchString);
                            break;
                        case PERSON:
                            productList = productInfo.findBooksByPerson(searchString);
                            break;
                    }
                    break;
                case FILM:
                    switch (searchCat) {
                        case ALL:
                            productList = productInfo.findFilms(searchString);
                            break;
                        case TITLE:
                            productList = productInfo.findFilmsByTitle(searchString);
                            break;
                        case PERSON:
                            productList = productInfo.findFilmsByPerson(searchString);
                            break;
                    }
                    break;
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ProductInfoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }
}
