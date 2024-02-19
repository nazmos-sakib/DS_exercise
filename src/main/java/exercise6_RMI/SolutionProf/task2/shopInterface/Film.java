package exercise6_RMI.SolutionProf.task2.shopInterface;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author neuhardt
 */
public class Film extends ProductDescription implements Serializable {

    private String format;
    private Set<Person> actors;
    private Person producer;
    
    public Film() {}
    
    public Film(String format, Person producer, String title, BigDecimal price, String supplierId) {
        super(title, price, supplierId);
        this.format = format;
        this.producer = producer;
        actors = new HashSet<>();
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Person getProducer() {
        return producer;
    }

    public void setProducer(Person producer) {
        this.producer = producer;
    }

    public void addActor(Person actor){
        actors.add(actor);
    }
    
    public Set<Person> getActors() {
        return actors;
    }

    public void setActors(Set<Person> actors) {
        this.actors = actors;
    }
    
    @Override
    public String getPersons() {
        StringBuilder stringBuild = new StringBuilder();
        Person[] personList = actors.toArray(new Person[actors.size()]);
        stringBuild.append(producer.getFirstname()).append(" ").append(producer.getLastname()).append(" (Producer); ");
        for (int i=0; i < personList.length; i++){
            stringBuild.append(personList[i].getFirstname()).append(" ").append(personList[i].getLastname()).append(" (Actor)");
            if (i < personList.length -1){
                stringBuild.append("; ");
            }
        }
        return stringBuild.toString();
    }
}
