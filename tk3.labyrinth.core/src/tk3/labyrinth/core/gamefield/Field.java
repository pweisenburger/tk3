package tk3.labyrinth.core.gamefield;

import java.util.Collection;
import java.util.Collections;

import tk3.labyrinth.core.gameelements.Start;

public class Field {
	
	private String name;
	
	private Collection<Room> rooms;

	private Start start;
	
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
	
	public Start getStart() {
		return start;
	}

	public void setStart(Start start) {
		this.start = start;
	}
}
