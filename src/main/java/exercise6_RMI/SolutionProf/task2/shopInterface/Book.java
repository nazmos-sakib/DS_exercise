package exercise6_RMI.SolutionProf.task2.shopInterface;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author neuhardt
 */
public class Book extends ProductDescription implements Serializable {

    private Date published;
    private Set<Person> authors;
    
    public Book() {}
    
    public Book(Date published, String title, BigDecimal price, String supplierId) {
        super(title, price, supplierId);
        this.published = published;
        authors = new HashSet<>();
    }
    
    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }
    
    public Set<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Person> authors) {
        this.authors = authors;
    }
    
    public void addAuthor(Person author) {
        authors.add(author);
    }

    @Override
    public String getPersons() {
        StringBuilder stringBuild = new StringBuilder();
        Person[] authorList = authors.toArray(new Person[authors.size()]);
        for (int i=0; i < authorList.length; i++){
            stringBuild.append(authorList[i].getFirstname()).append(" ").append(authorList[i].getLastname()).append(" (Author)");
            if (i < authorList.length -1){
                stringBuild.append("; ");
            }
        }
        return stringBuild.toString();
    }
}
