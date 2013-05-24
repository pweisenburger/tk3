package tk3.labyrinth.core.gamefield;

import tk3.labyrinth.core.gameelements.GameElement;
import tk3.labyrinth.core.shared.Position;

public class Room {
	private String id;
	private GameElement[][] gameElements;
	private int width;
	private int height;
	private int maxPlayer = -1;
	
	public Room(GameElement[][] gameElements) {
		this.gameElements = gameElements;
		this.width = 0;
		this.height = gameElements.length;
		
		for (int y = 0; y < gameElements.length; y++) {
			width = Math.max(width, gameElements[y].length);
			for (int x = 0; x < gameElements[y].length; x++)
				if (gameElements[y][x] != null)
					gameElements[y][x].initPosition(new Position(this, x, y));
		}
	}
	
	public GameElement getGameElement(int x, int y) {
		if (y >= 0 && y < gameElements.length &&
				x >= 0 && x < gameElements[y].length)
			return gameElements[y][x];
		return null;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setMaxPlayer(int maxPlayer) {
		this.maxPlayer = maxPlayer;
	}
	
	public int getMaxPlayer() {
		return maxPlayer;
	}
}
