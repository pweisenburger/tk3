package tk3.labyrinth;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class GameManager {
	private Game game;
	private List<String> games;
	private List<GameManagerObserver> observers;
	
	public GameManager() {
		games = new ArrayList<>();
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
	
	void startNewGame(Game game) {
		this.game = game;		
		for (GameManagerObserver o : observers)
			o.newGameStarted(game);
	}
	
	public void joinGame(String id) {
		for (GameManagerObserver o : observers)
			o.joinGame(id);
	}
	
	public void joinGame(Game game) {
		this.game = game;
		for (GameManagerObserver o : observers)
			o.gameJoined(game);
	}
}
