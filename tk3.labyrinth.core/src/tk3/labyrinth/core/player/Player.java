package tk3.labyrinth.core.player;

import tk3.labyrinth.Game;
import tk3.labyrinth.Observer;
import tk3.labyrinth.core.gameelements.Button;
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
		// validate new position
		GameElement ge = position.getRoom().getGameElement(position.getX(), position.getY());
		if (ge != null && !ge.isTraversable())
			return false;
		
		// inform observers
		Position oldPosition = this.position;
		this.position = position;
		for (Observer o : game.getObservers())
			o.playerMoved(this, oldPosition);
		
		// activate and deactivate activatable objects
		boolean deactivate = true;
		ge = oldPosition.getRoom().getGameElement(oldPosition.getX(), oldPosition.getY());
		if (ge instanceof Button) {
			Button button = (Button) ge;
			if (button.getReferencedElement() != null) {
				for (Player player : game.getPlayers())
					if (player != this && player.getPosition().equals(oldPosition))  {
						deactivate = false;
						break;
					}
				if (deactivate) {
					button.getReferencedElement().deactivate(button);
					for (Observer o : game.getObservers())
						o.elementActivated(button.getReferencedElement());
				}
			}
		}
		
		ge = position.getRoom().getGameElement(position.getX(), position.getY());
		boolean activate = true;
		if (ge instanceof Button) {
			Button button = (Button) ge;
			if (button.getReferencedElement() != null) {
				for (Player player : game.getPlayers())
					if (player != this && player.getPosition().equals(position))  {
						activate = false;
						break;
					}
				if (activate) {
					button.getReferencedElement().activate(button);
					for (Observer o : game.getObservers())
						o.elementActivated(button.getReferencedElement());
				}
			}
		}
		
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
