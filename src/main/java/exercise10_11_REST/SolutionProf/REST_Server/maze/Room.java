package exercise10_11_REST.SolutionProf.REST_Server.maze;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private int id;
	private String value = "";
	private List<Room> neighbours = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public void adddNeighbour(Room room) {
		neighbours.add(room);
	}
	public List<Room> getNeighbours() {
		return neighbours;
	}
	
}
