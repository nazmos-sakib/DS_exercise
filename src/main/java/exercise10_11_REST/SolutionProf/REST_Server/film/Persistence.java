package exercise10_11_REST.SolutionProf.REST_Server.film;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author neuhardt
 */
public class Persistence {

    private static Persistence persistence;
    private List<Film> films;
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
        films = new ArrayList<>();
        Film film = new Film(getNextId(), "2001: A space Odyssee", LocalDate.of(1968, 4, 2));
/*        film.addActor(new Actor("Dullea", "Keir"));
        film.addActor(new Actor("Lockwood", "Gary"));
 */       films.add(film);       
        film = new Film(getNextId(), "Alien", LocalDate.of(1979, 5, 25));
        film.addActor(new Actor("Skerritt", "Tom"));
        film.addActor(new Actor("Weaver", "Sigourney"));
        films.add(film);       
        film = new Film(getNextId(), "The Terminator", LocalDate.of(1984, 10, 6));
        film.addActor(new Actor("Schwarzenegger", "Arnold"));
        film.addActor(new Actor("Biehn", "Michael"));
        film.addActor(new Actor("Hamilton", "Linda"));
        films.add(film);       
    }
    
    public synchronized List<Film> findFilms(String searchString) {
    	List<Film> listFilms = new ArrayList<>();
    	for(Film film : films) {
    		if (film.getTitle().toLowerCase().contains(searchString.toLowerCase())){
    			listFilms.add(film);
    		}
    	}
        return listFilms;
    }
    
    public synchronized Film findFilm(int id) {
        for(Film film : films) {
        	if (film.getId() == id) {
        		return film;
        	}
        }
        throw new UnknownKeyException("Key: " + id);
    }
    
    public synchronized void addFilm(Film film) {
    	film.setId(getNextId());
    	films.add(film);
    }
    
    public synchronized void deleteFilm(int id) {
    	for(Film film : films) {
    		if (film.getId() == id) {
    			films.remove(film);
    			break;
    		}
    	}
    }
}

