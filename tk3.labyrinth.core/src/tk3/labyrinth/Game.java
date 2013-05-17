package tk3.labyrinth;

import java.util.List;

import tk3.labyrinth.core.gamefield.Field;
import tk3.labyrinth.core.player.Player;

public class Game {

	private Field field;
	private List<Player> players;
	
	private String id;
	
	public void addObserver(Observer o) {
		
	}
	
	public void removeObserver(Observer o) {
		
	}
	
	/**
	 * Legt neues Game Objekt an
	 * Laedt Karte
	 */
	public Game(String id, Field field, List<Player> players) {
		this.id = id;
		this.field = field;
		this.players = players;
	}
	

	
	public void addPlayer() {
		
	}
	
	public void removePlayer() {
		
	}
	

	
	
	
	
	
}
