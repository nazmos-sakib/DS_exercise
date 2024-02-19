package exercise10_11_REST.SolutionProf.REST_Server.maze;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class MazeController {
	private Maze maze;

	@GetMapping("/maze")
	public EntityModel<RoomT> getMaze() {
		maze = new Maze();
		return getModel(maze.getStart());
	}
	
	@GetMapping("rooms/{id}")
	public EntityModel<RoomT> getRoom(@PathVariable int id){
		Room room = maze.getRoom(id);
		return getModel(room);
	}
	
	@GetMapping("treasure/{id}")
	public EntityModel<RoomT> getTreasure(@PathVariable int id){
		Room room = maze.getRoom(id);
		if (room.getValue() .equals("Treasure")) {
			room.setValue("");
		}
		return getModel(room);
	}
	
	private EntityModel<RoomT> getModel(Room room) {
		RoomT roomT = new RoomT();
		roomT.setId(room.getId());
		roomT.setValue(room.getValue());
		EntityModel<RoomT> roomModel = EntityModel.of(roomT);
		for (int i = 0; i < room.getNeighbours().size(); i++) {
			Room r = room.getNeighbours().get(i);
			roomModel.add(linkTo(methodOn(MazeController.class).getRoom(r.getId())).withRel("neighbour " + (i+1)));
		}
		if (room.getValue().equals("Treasure")) {
			roomModel.add(linkTo(methodOn(MazeController.class).getTreasure(room.getId())).withRel("take treasure"));
		}
		return roomModel;
	}
}
