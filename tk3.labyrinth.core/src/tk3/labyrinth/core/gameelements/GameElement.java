package tk3.labyrinth.core.gameelements;

import tk3.labyrinth.core.shared.Position;

public abstract class GameElement {
	private Position position;

	public void initPosition(Position position) {
		if (this.position != null && this.position != position)
			throw new UnsupportedOperationException("Position already set");
		this.position = position;
	}
	
	/**
	 * Ist das Feld betretbar?
	 * 
	 * @return
	 */
	public abstract boolean isTraversable();

	public final String getId() {
		return position.getRoom().getId() + "#" + position.getX() + "#"
				+ position.getY();
	}

	public Position getPosition() {
		return position;
	}
}
