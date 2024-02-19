package exercise10_11_REST.SolutionProf.REST_Client.calculator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;


/**
 *
 * @author neuhardt
 */
public class CalculatorClient {
	public static String compute(String firstNumber, String secondNumber, String operation) {
		try {
			String obj = null;
			if (operation.equals("+")) {
				obj = "sum";
			} else if (operation.equals("-")) {
				obj = "difference";
			} else if (operation.equals("*")) {
				obj = "product";
			} else if (operation.equals("/")) {
				obj = "quotient";
			} else {
				return "Error: Unknown operation";
			}
			URI uri;
			uri = new URI("http://localhost:8080/" + obj + "?first=" + firstNumber + "&second=" + secondNumber);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
			return response.getBody();
		} catch (RestClientResponseException cre) {
			return "Error: " + cre.getResponseBodyAsString();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return "Error has occured";
	}
}
