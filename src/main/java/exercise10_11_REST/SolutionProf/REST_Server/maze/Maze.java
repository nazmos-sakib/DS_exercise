package exercise10_11_REST.SolutionProf.REST_Server.maze;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Maze {
	private List<Room> rooms;
	
	public Maze() {
		rooms = new ArrayList<>();
		for(int i = 0; i < 15; i++) {
			Room room = new Room();
			room.setId(i);
			rooms.add(room);
		}
		rooms.get(0).setValue("Entrance");
		Random random = new Random(new Date().getTime());
		int number = random.nextInt(8) + 7;
		rooms.get(number).setValue("Treasure");
		for (int i = 0; i < 7; i++) {
			rooms.get(i).adddNeighbour(rooms.get(2 * i + 1));
			rooms.get(2 * i + 1).adddNeighbour(rooms.get(i));
			rooms.get(i).adddNeighbour(rooms.get(2 * i + 2));
			rooms.get(2 * i + 2).adddNeighbour(rooms.get(i));
		}
		for (int i = 0; i < 20; i++) {
			number = random.nextInt(12) + 2;
			int id = rooms.get(1).getId();
			rooms.get(1).setId(rooms.get(number).getId());
			rooms.get(number).setId(id);
		}
		
		for(Room room : rooms) {
//			print(room);
		}
	}
	
	public Room getStart() {
		return rooms.get(0);
	}
	
	public Room getRoom(int id) {
		for (Room room : rooms) {
			if (room.getId() == id) {
				return room;
			}
		}
		return rooms.get(0);
	}
	
	private void print(Room room) {
		System.out.print("Room: "+room.getId()+", "+room.getValue()+", neighbours ");
		for (Room room1: room.getNeighbours()) {
			System.out.print(room1.getId()+",");
		}
		System.out.println();
	}
}
