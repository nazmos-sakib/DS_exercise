package exercise10_11_REST.SolutionProf.REST_Client.numbergame;

import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class NumbergameClient {
	private Observer observer;
	private String prime;
	private String notPrime;

	public NumbergameClient(Observer observer) {
		this.observer = observer;
		prime = null;
		notPrime = null;
	}
	
	public void newGame() {
		try {
			URI uri = new URI("http://localhost:8080/newgame");
			RestTemplate template = new RestTemplate();
			ResponseEntity<Gamestate> response = template.postForEntity(uri, new EmptyValue(), Gamestate.class);
			Gamestate gamestate = response.getBody();
			observer.update(gamestate);
			updateLinks();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			observer.showErrorMessage("Some error has occurred");
		}
	}
	
	public void isPrime() {
		try {
			URI uri = new URI(prime);
			RestTemplate template = new RestTemplate();
			ResponseEntity<Gamestate> response = template.postForEntity(uri, new EmptyValue(), Gamestate.class);
			Gamestate gamestate = response.getBody();
			uri = new URI("http://localhost:8080/gamestate");
			observer.update(gamestate);
			updateLinks();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			observer.showErrorMessage("Some error has occurred");
		}		
	}
	
	public void isNotPrime() {
		try {
			URI uri = new URI(notPrime);
			RestTemplate template = new RestTemplate();
			ResponseEntity<Gamestate> response = template.postForEntity(uri, new EmptyValue(), Gamestate.class);
			Gamestate gamestate = response.getBody();
			uri = new URI("http://localhost:8080/gamestate");
			observer.update(gamestate);
			updateLinks();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			observer.showErrorMessage("Some error has occurred");
		}		
	}
	
	private void updateLinks() {
		URI uri;
		try {
			uri = new URI("http://localhost:8080/gamestate");
			Traverson traverson = new Traverson(uri, MediaTypes.HAL_JSON);
			prime = traverson.follow("$._links.prime.href").asLink().getHref();
			notPrime = traverson.follow("$._links.notprime.href").asLink().getHref();	
		} catch (URISyntaxException e) {
			e.printStackTrace();
			observer.showErrorMessage("Some error has occurred");
		}		
	}
	
}
