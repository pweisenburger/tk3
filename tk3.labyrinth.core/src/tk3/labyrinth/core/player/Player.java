package tk3.labyrinth.core.player;

import tk3.labyrinth.Game;
import tk3.labyrinth.Observer;
import tk3.labyrinth.core.gameelements.GameElement;
import tk3.labyrinth.core.shared.Position;

public class Player {
	private String id;
	private Position position;
	private Game game;
	
	public Player(String id, Position position) {
		this.id = id;
		this.position = position;
	}
	
	public void initGame(Game game) {
		if (this.game != null)
			throw new UnsupportedOperationException("Position already set");
		this.game = game;
	}
	
	public boolean move(Position position) {
		GameElement ge = position.getRoom().getGameElement(position.getX(), position.getY());
		if (ge != null && !ge.isTraversable())
			return false;
		
		this.position = position;
		for (Observer o : game.getObservers())
			o.playerMoved(this);
		return true;
	}
	
	public String getId() {
		return id;
	}
	
	public Position getPosition() {
		return position;
	}

	public Game getGame() {
		return game;
	}
}
