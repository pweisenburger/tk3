package tk3.labyrinth.core.gamefield;

import tk3.labyrinth.core.gameelements.GameElement;

public class Room {
	
	private String id;
	
	private GameElement[][] gameElements;
	
	public Room(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
}
