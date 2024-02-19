package exercise10_11_REST.SolutionProf.REST_Client.film;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilmClient {
	
	public List<Film> findFilms(String searchString) {
		Film[] films;
		URI uri;
		try {
			uri = new URI("http://localhost:8080/films" + "?search=" + searchString);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Film[]> response = restTemplate.getForEntity(uri, Film[].class);
			films = response.getBody();
			return Arrays.asList(films);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return new ArrayList<Film>();
	}
	
	public Film findFilm(int id) {
		URI uri;
		try {
			uri = new URI("http://localhost:8080/films/" + id);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Film> response = restTemplate.getForEntity(uri, Film.class);
			return response.getBody();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			throw new RuntimeException("Unknown Error");
		} catch (RestClientResponseException cre) {
			throw new RuntimeException("Error: " + cre.getResponseBodyAsString());
		}
	}
	
	public int addFilm(String title, LocalDate publishedAt) {
		Film film = new Film(title, publishedAt);
		URI uri;
		try {
			uri = new URI("http://localhost:8080/films");
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.postForEntity(uri, film, String.class);
			return response.getStatusCode().value();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			throw new RuntimeException("Unknown Error");
		} catch (RestClientResponseException cre) {
			throw new RuntimeException("Error: " + cre.getResponseBodyAsString());
		}		
	}
	
	public void deleteFilm(int id) {
		URI uri;
		try {
			uri = new URI("http://localhost:8080/films/" + id);
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.delete(uri);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			throw new RuntimeException("Unknown Error");
		} catch (RestClientResponseException cre) {
			throw new RuntimeException("Error: " + cre.getResponseBodyAsString());
		}		
	}

	public int addActor(int filmId, String firstName, String lastName) {
		URI uri;
		try {
			uri = new URI("http://localhost:8080/films/" + filmId + "/actor");
			Actor actor = new Actor(lastName, firstName);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.postForEntity(uri, actor, String.class);
			return response.getStatusCode().value();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			throw new RuntimeException("Unknown Error");
		} catch (RestClientResponseException cre) {
			cre.printStackTrace();
			throw new RuntimeException("Error: " + cre.getResponseBodyAsString());
		}		
	}

}
