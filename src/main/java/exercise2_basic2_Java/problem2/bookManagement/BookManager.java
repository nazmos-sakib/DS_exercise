package exercise2_basic2_Java.problem2.bookManagement;

import java.util.List;

public interface BookManager {
    void createAuthor(String firstName, String lastName);
    List<Author> searchAuthor(String search);

    void createBook(String title, List<Author> authors);
    List<Book> searchBook(String search);
}
