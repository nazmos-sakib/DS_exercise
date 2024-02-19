package exercise10_11_REST.SolutionProf.REST_Client.film;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author neuhardt
 */
public class Film {

	private int id;
	private String title;
	private LocalDate publishedAt;
    private List<Actor> actors;
    
    public Film() {}
       
    public Film(String title, LocalDate publishedAt) {
		super();
		this.title = title;
		this.publishedAt = publishedAt;
		this.actors = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(LocalDate publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public void addActor(Actor actor) {
		actors.add(actor);
	}

}
