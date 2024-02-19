package exercise10_11_REST.SolutionProf.REST_Server.numbergame;

public class Gamestate {
	private final String score;
	private final String number;
	private String message;

	public Gamestate(String score, String number) {
		this.score = score;
		this.number = number;
		this.message = "";
	}

	public String getScore() {
		return score;
	}

	public String getNumber() {
		return number;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
