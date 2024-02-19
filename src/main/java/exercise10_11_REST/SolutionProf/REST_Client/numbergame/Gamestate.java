package exercise10_11_REST.SolutionProf.REST_Client.numbergame;

public class Gamestate {
	private String score;
	private String number;
	private String message;
	
	public Gamestate() {
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public void setNumber(String number) {
		this.number = number;
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
