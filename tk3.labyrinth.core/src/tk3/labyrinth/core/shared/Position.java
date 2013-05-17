package tk3.labyrinth.core.shared;

import tk3.labyrinth.core.gamefield.Room;

public class Position {
	
	private Room room;
	private int x;
	private int y;
	
	public Position(Room room, int x, int y) {
		this.room = room;
		this.x = x;
		this.y = y;
	}
	
	public int getX()  {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Room getRoom() {
		return room;
	}

}
