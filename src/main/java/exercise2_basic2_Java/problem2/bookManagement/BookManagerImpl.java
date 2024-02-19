package exercise2_basic2_Java.problem2.bookManagement;

import exercise2_basic2_Java.problem2.persistent.Persistent;

import java.util.List;

public class BookManagerImpl implements BookManager{
    @Override
    public void createAuthor(String firstName, String lastName) {
        Persistent.getInstance().persist(new Author(firstName,lastName));
    }

    @Override
    public List<Author> searchAuthor(String search) {
        return Persistent.getInstance().searchAuthors(search);
    }

    @Override
    public void createBook(String title, List<Author> authors) {
        Persistent.getInstance().persist(new Book(title,authors));
    }

    @Override
    public List<Book> searchBook(String search) {
        return Persistent.getInstance().searchBook(search);
    }
}
