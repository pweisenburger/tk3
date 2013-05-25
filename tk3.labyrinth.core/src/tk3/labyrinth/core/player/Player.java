package tk3.labyrinth.core.player;

import tk3.labyrinth.Game;
import tk3.labyrinth.GameObserver;
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
	
	// returns 0, if the move was performed
	//         1, if the position is not traversable
	//         2, if the player could not enter the room due to max player limit
	public int move(Position position) {
		// validate new position
		GameElement ge = position.getRoom().getGameElement(position.getX(), position.getY());
		if (ge != null && !ge.isTraversable())
			return 1;
		
		// check room player limit
		if (this.position.getRoom() != position.getRoom()) {
			int maxPlayer = position.getRoom().getMaxPlayer();
			if (maxPlayer > 0) {
				for (Player player : game.getPlayers())
					if (player.getPosition().getRoom() == position.getRoom())
						maxPlayer--;
				if (maxPlayer < 1)
					return 2;
			}
		}
		
		// inform observers
		Position oldPosition = this.position;
		this.position = position;
		for (GameObserver o : game.getObservers())
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
					boolean activated = button.getReferencedElement().isActive();
					button.getReferencedElement().deactivate(button);
					if (activated != button.getReferencedElement().isActive())
						for (GameObserver o : game.getObservers())
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
					boolean activated = button.getReferencedElement().isActive();
					button.getReferencedElement().activate(button);
					if (activated != button.getReferencedElement().isActive())
						for (GameObserver o : game.getObservers())
							o.elementActivated(button.getReferencedElement());
				}
			}
		}
		
		return 0;
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
