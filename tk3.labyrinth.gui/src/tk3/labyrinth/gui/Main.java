package tk3.labyrinth.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.List;

import tk3.labyrinth.Game;
import tk3.labyrinth.GameManager;
import tk3.labyrinth.core.gameelements.Button;
import tk3.labyrinth.core.gameelements.Door;
import tk3.labyrinth.core.gameelements.GameElement;
import tk3.labyrinth.core.gameelements.Wall;
import tk3.labyrinth.core.gamefield.Field;
import tk3.labyrinth.core.gamefield.Room;
import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.core.shared.Position;
import tk3.labyrinth.umundo.UmundoManager;

public class Main {
	public static void main(String[] args) {
		final GameManager manager = new GameManager();
		
		final UmundoManager umundoManager = new UmundoManager(manager);
		
		final GameFrame frame = new GameFrame(manager);
		frame.setDefaultCloseOperation(GameFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				umundoManager.close();
			}
		});
	}
	
	public static Game testGame(String gameId, String playerId) {
		Button button0;
		Door door0, door1, door2, door3;
		
		GameElement elements0[][] = {
			{ new Wall(), door0 = new Door(), new Wall(), new Wall() },
			{ door2 = new Door(), null, null, new Wall() },
			{ new Wall(), null, null, new Wall() },
			{ new Wall(), null, button0 = new Button(), new Wall() },
			{ new Wall(), new Wall(), new Wall(), new Wall() }
		};
		
		GameElement elements1[][] = {
			{ new Wall(), new Wall(), new Wall(), new Wall() },
			{ new Wall(), null, null, new Wall() },
			{ new Wall(), null, null, new Wall() },
			{ new Wall(), null, null, new Wall() },
			{ new Wall(), new Wall(), door1 = new Door(), new Wall() }
		};
		
		GameElement elements2[][] = {
			{ new Wall(), new Wall(), new Wall(), new Wall(), new Wall() },
			{ new Wall(), null, null, null, new Wall() },
			{ null, new Wall(), null, null, door3 = new Door() },
			{ null, new Wall(), null, null, new Wall() },
			{ null, new Wall(), new Wall(), new Wall(), new Wall() }
		};
		
		door0.initDoor(door1);
		door1.initDoor(door0);
		door2.initDoor(door3);
		door3.initDoor(door2);
		
		button0.initReferencedElement(door0);
		
		//door0.activate(null);
		door1.activate(null);
		door2.activate(null);
		door3.activate(null);
		
		Room room0 = new Room(elements0);
		Room room1 = new Room(elements1);
		Room room2 = new Room(elements2);
		
		room0.setId("Room 0");
		room1.setId("Room 1");
		room2.setId("Room 2");
		
		List<Room> rooms = Arrays.asList(room0, room1, room2);
		
		Field field = new Field("", rooms);
		List<Player> players = Arrays.asList(new Player(playerId, new Position(rooms.get(0), 1, 2)), new Player("other", new Position(rooms.get(0), 2, 3)));
		Game game = new Game(gameId, field, players);
		game.setOwnPlayer(players.get(0));
		
		return game;
	}
}
