package exercise10_11_REST.SolutionProf.REST_Server.film;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {
	
	@GetMapping("/films")
	public List<Film> getFilms(@RequestParam("search") String searchString){
		return new FilmManager().findFilms(searchString);
	}

	@GetMapping("/films/{id}")
	public ResponseEntity<Object> getFilm(@PathVariable int id){
		try {
			Film film = new FilmManager().findFilm(id);
			return ResponseEntity.ok(film);
		} catch (UnknownKeyException ex) { 
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@DeleteMapping("/films/{id}")
	public void deleteFilm(@PathVariable int id){
			new FilmManager().deleteFilm(id);
	}

	@PostMapping("/films")
	@ResponseStatus(HttpStatus.CREATED)
	public void addfilm(@RequestBody Film film) {
		new FilmManager().addFilm(film);
	}
	
	@PostMapping("/films/{id}/actor")
	@ResponseStatus(HttpStatus.CREATED)
	public void addActor(@PathVariable int id, @RequestBody Actor actor) {
		new FilmManager().addActor(id, actor);
	}


}
