package tk3.labyrinth.core.gamefield;

import java.util.ArrayList;
import java.util.List;

public class Field {
	
	private String id;
	
	private List<Room> rooms = new ArrayList<>();
	
	public Field(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	public void addRoom(Room room) {
		rooms.add(room);
	}
	
	public void removeRoom(Room room) {
		rooms.remove(room);
	}
	
	public Room getRoom(String id) {
		for(Room room : rooms) {
			if (room.getId().equals(id)) {
				return room;
			}
		}
		return null;
	}
}
