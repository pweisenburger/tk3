package tk3.labyrinth;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tk3.labyrinth.core.gameelements.IActivatable;
import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.core.shared.Position;

public class GameManager {
	private Game game;
	private Set<String> games;
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
		games = new HashSet<String>();
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
	
	public Set<String> getGames() {
		return Collections.unmodifiableSet(games);
	}
	
	public Game getGame() {
		return game;
	}
	
	public void setGames(Set<String> games) {
		this.games = games;
		for (GameManagerObserver o : observers){
			//o.gameListChanged(Collections.unmodifiableList(games));
			o.gameListChanged(Collections.unmodifiableSet(games));
		}
	}
	
	public void addGame(String gameId) {
		if(!games.contains(gameId)) {
			for (GameManagerObserver o : observers){
				//o.gameListChanged(Collections.unmodifiableList(games));
				o.gameListChanged(Collections.unmodifiableSet(games));
			}
		}
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