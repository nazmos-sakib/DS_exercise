package exercise6_RMI.solution.task2.shopServer;

import exercise6_RMI.solution.task2.shopInterface.Book;
import exercise6_RMI.solution.task2.shopInterface.Film;
import exercise6_RMI.solution.task2.shopInterface.Person;
import exercise6_RMI.solution.task2.shopInterface.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author neuhardt
 */
public class Persistence {

    private static Persistence persistence;
    private List<Product> products;
    private static int id = 1;

    public static synchronized Persistence getInstance() {
        if (persistence == null) {
            persistence = new Persistence();
        }
        return persistence;
    }
    
    private int getNextId(){
        return id++;
    }

    private Persistence() {
        products = new ArrayList<>();
        Person person = new Person("Rozanski", "Uwe");
        Book book = new Book(new GregorianCalendar(2011, 2, 17).getTime(), "Enterprise JavaBeans 3.1", new BigDecimal("39.95"), "EJB-1001");
        book.addAuthor(person);
        Product product = new Product(book, 3);
        persist(product);
        book = new Book(new GregorianCalendar(2011, 7, 29).getTime(),"EJB 3.1 professionell", new BigDecimal("54.90"), "EJB-1002");
        person = new Person("Ihns", "Oliver");
        book.addAuthor(person);
        person = new Person("Harbeck", "Dirk");
        book.addAuthor(person);
        product = new Product(book, 2);
        persist(product);
        book = new Book(new GregorianCalendar(2010, 9, 20).getTime(), "Enterprise JavaBeans 3.1", new BigDecimal("34.95"), "EJB-1003");
        person = new Person("Burke", "Bill");
        book.addAuthor(person);
        person = new Person("Rubinger", "Anton Lee");
        book.addAuthor(person);
        product = new Product(book, 1);
        persist(product);
        book = new Book(new GregorianCalendar(2017, 12, 07).getTime(), "Functional Programming Simplified", new BigDecimal("30.32"), "SE-2001");
        person = new Person("Alexander", "Alvin");
        book.addAuthor(person);
        product = new Product(book, 4);
        persist(product);
        Film film = new Film("DVD", new Person("Kubrick", "Stanley"), "2001: A space Odyssee", new BigDecimal("19.98"), "F-3001");
        person = new Person("Dullea", "Keir");
        film.addActor(person);
        person = new Person("Lockwood", "Gary");
        film.addActor(person);
        product = new Product(film, 3);
        persist(product);       
        film = new Film("Blue-ray", new Person("Scott", "Ridley"), "Alien", new BigDecimal("9.97"), "F-3002");
        person = new Person("Skerritt", "Tom");
        film.addActor(person);
        person = new Person("Weaver", "Sigourney");
        film.addActor(person);
        product = new Product(film, 4);
        persist(product);       
    }
    
    private void persist(Product product){
        product.setId(getNextId());
        products.add(product);
    }
    
    public synchronized List<Product> findProducts(String searchString){
        List<Product> listProducts = findBooks(searchString);
        listProducts.addAll(findFilms(searchString));
        return listProducts;
        
    }

    public synchronized List<Product> findProductsByTitle(String searchString) {
        List<Product> listProducts = findBooksByTitle(searchString);
        listProducts.addAll(findFilmsByTitle(searchString));
        return listProducts;
    }

    public synchronized List<Product> findProductsByPerson(String searchString) {
        List<Product> listProducts = findBooksByPerson(searchString);
        listProducts.addAll(findFilmsByPerson(searchString));
        return listProducts;
    }

    public synchronized List<Product> findBooks(String searchString){
        List<Product> listProducts = findBooksByTitle(searchString);
        List<Product> listProducts2 = findBooksByPerson(searchString);
        for (Product product : listProducts2){
            if (!listProducts.contains(product)){
                listProducts.add(product);
            }
        }
        return listProducts;        
    }

    public synchronized List<Product> findBooksByTitle(String searchString) {
        List<Product> listProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getDescription().getClass().equals(Book.class) && product.getDescription().getTitle().toLowerCase().contains(searchString.toLowerCase())) {
                listProducts.add(product);
            }
        }
        return listProducts;
    }

    public synchronized List<Product> findBooksByPerson(String searchString) {
        List<Product> listProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getDescription().getClass().equals(Book.class)) {
                Book book = (Book) product.getDescription();
                boolean hit = false;
                for (Person person : book.getAuthors()) {
                    if (person.getLastname().toLowerCase().contains(searchString.toLowerCase())) {
                        hit = true;
                    }
                }
                if (hit) {
                    listProducts.add(product);
                }
            }
        }
        return listProducts;
    }

    public synchronized List<Product> findFilms(String searchString){
        List<Product> listProducts = findFilmsByTitle(searchString);
        List<Product> listProducts2 = findFilmsByPerson(searchString);
        for (Product product : listProducts2){
            if (!listProducts.contains(product)){
                listProducts.add(product);
            }
        }
        return listProducts;        
    }

    public synchronized List<Product> findFilmsByTitle(String searchString) {
        List<Product> listProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getDescription().getClass().equals(Film.class) && product.getDescription().getTitle().toLowerCase().contains(searchString.toLowerCase())) {
                listProducts.add(product);
            }
        }
        return listProducts;
    }

    public synchronized List<Product> findFilmsByPerson(String searchString) {
        List<Product> listProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getDescription().getClass().equals(Film.class)) {
                Film film = (Film) product.getDescription();
                boolean hit = false;
                for (Person person : film.getActors()) {
                    if (person.getLastname().toLowerCase().contains(searchString.toLowerCase())) {
                        hit = true;
                    }
                }
                if (film.getProducer().getLastname().toLowerCase().contains(searchString.toLowerCase())){
                    hit = true;
                }
                if (hit) {
                    listProducts.add(product);
                }
            }
        }
        return listProducts;
    }

}
