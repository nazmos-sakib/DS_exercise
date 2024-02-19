package exercise2_basic2_Java.problem2.persistent;


import exercise2_basic2_Java.problem2.bookManagement.Author;
import exercise2_basic2_Java.problem2.bookManagement.Book;

import java.util.ArrayList;
import java.util.List;

public class Persistent {
    private static Persistent instance;
    private static int nextId = 1;
    private static int nextBookId = 1;

    private ArrayList<Author> authors;
    private ArrayList<Book> books;
    private Persistent() {
        authors = new ArrayList<>();
        books = new ArrayList<>();
    }
    public static Persistent getInstance() {
        if (instance == null) {
            instance = new Persistent();
        }
        return instance;
    }

    public void persist(Author author) {
        author.setId(nextId);
        nextId++;
        authors.add(author);
    }

    public List<Author> searchAuthors(String search){
        List<Author> result = new ArrayList<>();
        authors.forEach((author)->{
            if (author.getLastName().contains(search)){
                result.add(author);
            }
        });
        return result;
    }

    public void persist(Book book) {
        book.setId(nextBookId);
        nextBookId++;
        books.add(book);
    }

    public List<Book> searchBook(String search){
        List<Book> result = new ArrayList<>();
        books.forEach((b)->{
            if (b.getTitle().contains(search)){
                result.add(b);
            }
        });
        return result;
    }

}
