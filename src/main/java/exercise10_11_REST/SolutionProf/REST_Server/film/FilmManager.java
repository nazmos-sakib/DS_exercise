package exercise10_11_REST.SolutionProf.REST_Server.film;

import java.util.List;

public class FilmManager {
    
    public List<Film> findFilms(String searchString) {
        Persistence persistence = Persistence.getInstance();
        return persistence.findFilms(searchString);
    }
    
    public Film findFilm(int id) {
        Persistence persistence = Persistence.getInstance();
        return persistence.findFilm(id);
    }
    
    public void addFilm(Film film) {
        Persistence persistence = Persistence.getInstance();
    	persistence.addFilm(film);
    }
    
    public void deleteFilm(int id) {
        Persistence persistence = Persistence.getInstance();
    	persistence.deleteFilm(id);
   	
    }
    
    public void addActor(int id, Actor actor) {
    	Persistence persistence = Persistence.getInstance();
    	Film film = persistence.findFilm(id);
    	film.addActor(actor);
    }
}
