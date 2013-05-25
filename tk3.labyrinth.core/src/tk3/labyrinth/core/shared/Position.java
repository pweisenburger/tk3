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
	
	@Override
	public String toString() {
		return getRoom().getId() + " (" + x + "," + y + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
