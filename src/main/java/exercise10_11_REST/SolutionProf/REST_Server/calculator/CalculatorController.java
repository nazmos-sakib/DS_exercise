package exercise10_11_REST.SolutionProf.REST_Server.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

	@GetMapping("/sum")
	public String gerSum(@RequestParam("first") String first, @RequestParam("second") String second) {
		int firstInt = Integer.parseInt(first);
		int secondInt = Integer.parseInt(second);
		return Integer.toString(firstInt + secondInt);
	}

	@GetMapping("/difference")
	public String gerDifference(@RequestParam("first") String first, @RequestParam("second") String second) {
		int firstInt = Integer.parseInt(first);
		int secondInt = Integer.parseInt(second);
		return Integer.toString(firstInt - secondInt);
	}

	@GetMapping("/product")
	public String gerProductSum(@RequestParam("first") String first, @RequestParam("second") String second) {
		int firstInt = Integer.parseInt(first);
		int secondInt = Integer.parseInt(second);
		return Integer.toString(firstInt * secondInt);
	}

	@GetMapping("/quotient")
	public String gerQuotient(@RequestParam("first") String first, @RequestParam("second") String second) {
		int firstInt = Integer.parseInt(first);
		int secondInt = Integer.parseInt(second);
		return Integer.toString(firstInt / secondInt);
	}

}
