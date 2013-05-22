package tk3.labyrinth.core.gamefield;

import java.util.Collections;
import java.util.List;

public class Field {
	private List<Room> rooms;
	
	public Field(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public List<Room> getRooms() {
		return Collections.unmodifiableList(rooms);
	}
}
