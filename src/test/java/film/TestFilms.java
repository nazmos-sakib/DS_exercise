package film;

import exercise10_11_REST.SolutionProf.REST_Client.film.Film;
import exercise10_11_REST.SolutionProf.REST_Client.film.FilmClient;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestFilms {

	@Test
	public void searchFilms() {
		List<Film> films = new FilmClient().findFilms("o");
		assertEquals(2, films.size());
		assertTrue(films.get(0).getTitle().equals("2001: A space Odyssee") ||
				films.get(0).getTitle().equals("2001: A space Odyssee"));
		
	}

	@Test
	public void searchFilmsEmptyList() {
		List<Film> films = new FilmClient().findFilms("xy");
		assertEquals(0, films.size());		
	}

	@Test
	public void findFilm() {
		Film film = new FilmClient().findFilm(2);
		assertEquals("Alien", film.getTitle());		
	}

	@Test
	public void findFilmNotFound() {
		Exception ex = assertThrows(RuntimeException.class, () -> new FilmClient().findFilm(100));
		assertTrue(ex.getMessage().contains("Error:"));
	}
	
	@Test
	public void addAndDeleteFilm() {
		FilmClient filmClient = new FilmClient();
		int statusCode = filmClient.addFilm("Film123", LocalDate.now());
		assertEquals(201, statusCode);
		List<Film> list = filmClient.findFilms("Film123");
		assertEquals(1, list.size());
		filmClient.deleteFilm(list.get(0).getId());
		list = filmClient.findFilms("Film123");
		assertEquals(0, list.size());
	}
	
	@Test
	public void addActor() {
		FilmClient filmClient = new FilmClient();
		String title = "Film789";
		int statusCode = filmClient.addFilm(title, LocalDate.now());
		assertEquals(201, statusCode);
		List<Film> list = filmClient.findFilms(title);
		assertTrue(list.size() >= 1);
		int filmId = list.get(0).getId();
		assertEquals(0, list.get(0).getActors().size());
		filmClient.addActor(filmId, "Jane", "Doe");		
		Film film = filmClient.findFilm(filmId);
		assertEquals(1, film.getActors().size());
		assertEquals("Doe", film.getActors().get(0).getLastname());
		filmClient.deleteFilm(filmId);
	}
	
	

}
