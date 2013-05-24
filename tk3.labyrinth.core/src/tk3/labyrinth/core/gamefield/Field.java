package tk3.labyrinth.core.gamefield;

import java.util.Collection;
import java.util.Collections;

public class Field {
	
	private String name;
	
	private Collection<Room> rooms;
	
	public Field(String name, Collection<Room> rooms) {
		this.rooms = rooms;
		this.name = name;
	}
	
	public Collection<Room> getRooms() {
		return Collections.unmodifiableCollection(rooms);
	}

	public String getName() {
		return name;
	}
}
