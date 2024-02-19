package exercise10_11_REST.SolutionProf.REST_Server.film;

import java.io.Serializable;

/**
 *
 * @author neuhardt
 */
public class Actor implements Serializable {
    
    private String lastname;
    private String firstname;

    public Actor() {}
    
    public Actor(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
 
}
