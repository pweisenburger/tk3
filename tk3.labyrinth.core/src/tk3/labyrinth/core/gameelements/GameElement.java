package tk3.labyrinth.core.gameelements;

import tk3.labyrinth.core.gamefield.Room;
import tk3.labyrinth.core.shared.Position;

public abstract class GameElement {
	
	private Position position;
	
	/**
	 * Ist das Feld betretbar?
	 * @return
	 */
	public abstract boolean isTraversable();
	
	public final String getId() {
		return position.getRoom().getId() + "#" + position.getX() + "#" + position.getY(); 
	}

}
