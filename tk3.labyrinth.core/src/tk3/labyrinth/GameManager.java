package tk3.labyrinth;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import tk3.labyrinth.core.gameelements.IActivatable;
import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.core.shared.Position;

public class GameManager {
	private Game game;
	private List<String> games;
	private List<GameManagerObserver> observers;
	private GameObserver gameObserver = new GameObserver() {
		public void playerRemoved(Player player) {
			if (player == game.getOwnPlayer())
				leaveGame();
		}
		public void playerMoved(Player player, Position oldPosition) {}
		public void playerAdded(Player player) { }
		public void elementActivated(IActivatable ge) { }
	};
	
	public GameManager() {
		games = new ArrayList<>();
		observers = new ArrayList<>();
	}
	
	public void addObserver(GameManagerObserver o) {
		observers.add(o);
	}
	
	public void removeObserver(GameManagerObserver o) {
		observers.remove(o);
	}
	
	public List<GameManagerObserver> getObservers() {
		return Collections.unmodifiableList(observers);
	}
	
	public List<String> getGames() {
		return games;
	}
	
	public Game getGame() {
		return game;
	}
	
	public void setGames(List<String> games) {
		this.games = games;
		for (GameManagerObserver o : observers)
			o.gameListChanged(Collections.unmodifiableList(games));
	}
	
	public void startNewGame(Game game) {
		this.game = game;	
		this.game.addObserver(gameObserver);
		for (GameManagerObserver o : observers)
			o.newGameStarted(game);
	}
	
	public void joinGame(String id) {
		for (GameManagerObserver o : observers)
			o.joinGame(id);
	}
	
	public void joinGame(Game game) {
		this.game = game;
		this.game.addObserver(gameObserver);
		for (GameManagerObserver o : observers)
			o.gameJoined(game);
	}
	
	public void leaveGame() {
		if (game != null) {
			game.removeObserver(gameObserver);
			for (GameManagerObserver o : observers)
				o.gameLeft(game);
		}
		game = null;
	}
}
