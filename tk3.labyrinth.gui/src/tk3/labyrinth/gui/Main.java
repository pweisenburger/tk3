package tk3.labyrinth.gui;

import java.util.Arrays;
import java.util.List;

import tk3.labyrinth.Game;
import tk3.labyrinth.core.gameelements.GameElement;
import tk3.labyrinth.core.gameelements.Wall;
import tk3.labyrinth.core.gamefield.Field;
import tk3.labyrinth.core.gamefield.Room;
import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.core.shared.Position;

public class Main {
	public static void main(String[] args) {
		GameElement elements[][] = {
			{ new Wall(), new Wall(), new Wall(), new Wall() },
			{ new Wall(), null, null, new Wall() },
			{ new Wall(), null, null, new Wall() },
			{ new Wall(), null, null, new Wall() },
			{ new Wall(), new Wall(), new Wall(), new Wall() }
		};
		
		List<Room> rooms = Arrays.asList(new Room(elements));
		Field field = new Field(rooms);
		List<Player> players = Arrays.asList(new Player("player", new Position(rooms.get(0), 1, 1)));
		Game game = new Game("Test Game", field, players);
		
		new GameFrame(game);
	}
}
