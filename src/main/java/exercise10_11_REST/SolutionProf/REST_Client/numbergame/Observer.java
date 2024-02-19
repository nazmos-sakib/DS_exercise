package exercise10_11_REST.SolutionProf.REST_Client.numbergame;

public interface Observer {
	void update(Gamestate gamestate);
	void showErrorMessage(String message);
}
