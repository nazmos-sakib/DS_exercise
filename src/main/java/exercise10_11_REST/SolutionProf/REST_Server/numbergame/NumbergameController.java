package exercise10_11_REST.SolutionProf.REST_Server.numbergame;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class NumbergameController {
	private Numbergame game;
	
	@GetMapping("/gamestate")
	public EntityModel<Gamestate> getGamestate() {
		if (game == null) {
			game = new Numbergame();
		}
		return getModel(game.getGamestate());
	}
	
	@PostMapping("/gamestate/{number}/prime")
	public EntityModel<Gamestate> isPrime(@PathVariable String number) {
		String message = game.isPrime(number);
		Gamestate gamestate = game.getGamestate();
		gamestate.setMessage(message);
		return EntityModel.of(gamestate);
	}

	@PostMapping("/gamestate/{number}/notprime")
	public EntityModel<Gamestate> isNotPrime(@PathVariable String number) {
		String message = game.isNotPrime(number);
		game.newNumber();
		Gamestate gamestate = game.getGamestate();
		gamestate.setMessage(message);
		return EntityModel.of(gamestate);
	}
	
	@PostMapping("/newgame")
	public  EntityModel<Gamestate> newGame(@RequestBody String s){
		game = new Numbergame();
		Gamestate gamestate = game.getGamestate();
		gamestate.setMessage("New game started");
		return EntityModel.of(gamestate);
	}

	private EntityModel<Gamestate> getModel(Gamestate gamestate){
		EntityModel<Gamestate> model = EntityModel.of(gamestate);
		model.add(linkTo(methodOn(NumbergameController.class).isPrime(gamestate.getNumber())).withRel("prime"),
					linkTo(methodOn(NumbergameController.class).isNotPrime(gamestate.getNumber())).withRel("notprime"),
					linkTo(methodOn(NumbergameController.class).newGame(" ")).withRel("new"));
		return model;
		
	}

}
