package tk3.labyrinth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tk3.labyrinth.core.gamefield.Field;
import tk3.labyrinth.core.player.Player;

public class Game {
	private Field field;
	private List<Player> players;
	private List<Observer> observers;
	private String id;
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	public List<Observer> getObservers() {
		return Collections.unmodifiableList(observers);
	}
	
	/**
	 * Legt neues Game Objekt an
	 * Laedt Karte
	 */
	public Game(String id, Field field, List<Player> players) {
		this.id = id;
		this.field = field;
		this.players = players;
		
		observers = new ArrayList<>();
		
		for (Player player : players)
			player.initGame(this);
	}
	
	public void addPlayer(Player player) {
		players.add(player);
		player.initGame(this);
	}
	
	public void removePlayer(Player player) {
		players.remove(player);
	}
	
	public Field getField() {
		return field;
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public String getId() {
		return id;
	}
}
