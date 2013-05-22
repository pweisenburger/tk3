package tk3.labyrinth.core.gamefield;

import java.util.Collection;
import java.util.Collections;

public class Field {
	private Collection<Room> rooms;
	
	public Field(Collection<Room> rooms) {
		this.rooms = rooms;
	}
	
	public Collection<Room> getRooms() {
		return Collections.unmodifiableCollection(rooms);
	}
}
