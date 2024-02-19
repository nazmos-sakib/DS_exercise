package exercise6_RMI.solution.task2.shopInterface;

import java.io.Serializable;

public class Person implements Serializable {
    
    private String lastname;
    private String firstname;

    public Person() {}
    
    public Person(String lastname, String firstname) {
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
