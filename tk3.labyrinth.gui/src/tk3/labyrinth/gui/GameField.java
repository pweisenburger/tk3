package tk3.labyrinth.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import javax.swing.JComponent;

import tk3.labyrinth.Game;
import tk3.labyrinth.Observer;
import tk3.labyrinth.core.gameelements.Door;
import tk3.labyrinth.core.gameelements.GameElement;
import tk3.labyrinth.core.gamefield.Room;
import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.core.shared.Position;

@SuppressWarnings("serial")
public class GameField extends JComponent implements Observer {
	private static class DoorEntry {
		boolean bottom, right, top, left;
	}
	
	private Game game;
	private Map<Room, Point> roomPosition;
	private Map<Door, DoorEntry> doorEntry;
	private Player player;
	
	static final private int elementSize = 16;
	
	public GameField(Game game) {
		super();
		this.game = game;
		
		game.addObserver(this);
		
		doorEntry = new HashMap<>();
		for (Room room : game.getField().getRooms())
			for (int y = 0; y < room.getHeight(); y++)
				for (int x = 0; x < room.getWidth(); x++)
					if (room.getGameElement(x, y) instanceof Door)
						findDoorEntries((Door) room.getGameElement(x, y));
		
		roomPosition = new HashMap<>();
		int sepOffset = -990;
		for (Room room : game.getField().getRooms()) {
			if (!roomPosition.containsKey(room))
				roomPosition.put(room, new Point(sepOffset += 1000, 0));
			
			Queue<Room> rooms = new LinkedList<>();
			rooms.add(room);
			
			while (!rooms.isEmpty()) {
				Room room0 = rooms.poll();
				
				for (int y = 0; y < room0.getHeight(); y++)
					for (int x = 0; x < room0.getWidth(); x++)
						if (room0.getGameElement(x, y) instanceof Door) {
							Door door0 = (Door) room0.getGameElement(x, y);
							Door door1 = door0.getDoor();
							
							if (door1 != null && !roomPosition.containsKey(door1.getPosition().getRoom())) {
								Room room1 = door1.getPosition().getRoom();
								if (roomPosition.containsKey(room1))
									continue;
								
								DoorEntry entry0 = doorEntry.get(door0);
								DoorEntry entry1 = doorEntry.get(door1);
								
								Point point0 = roomPosition.get(room0);
								Point point1 = new Point(point0.x - door1.getPosition().getX() + door0.getPosition().getX(),
										                 point0.y - door1.getPosition().getY() + door0.getPosition().getY());
								
								if (!entry0.bottom && !entry1.top
										&& !isRoomIntersection(room1, new Point(point1.x, point1.y + 1), roomPosition))
									roomPosition.put(room1, new Point(point1.x, point1.y + 1));
								else if (!entry0.top && !entry1.bottom
										&& !isRoomIntersection(room1, new Point(point1.x, point1.y - 1), roomPosition))
									roomPosition.put(room1, new Point(point1.x, point1.y - 1));
								else if (!entry0.right && !entry1.left
										&& !isRoomIntersection(room1, new Point(point1.x + 1, point1.y), roomPosition))
									roomPosition.put(room1, new Point(point1.x + 1, point1.y));
								else if (!entry0.left && !entry1.right
										&& !isRoomIntersection(room1, new Point(point1.x - 1, point1.y), roomPosition))
									roomPosition.put(room1, new Point(point1.x - 1, point1.y));
								
								else if (!entry0.bottom && !entry1.top && entry1.bottom && entry0.top) {
									Point point = new Point(point1.x, point1.y + 2);
									while (isRoomIntersection(room1, point, roomPosition))
										point.y++;
									point.y++;
									roomPosition.put(room1, point);
								}
								else if (!entry0.top && !entry1.bottom && entry1.top && entry0.bottom) {
									Point point = new Point(point1.x, point1.y - 2);
									while (isRoomIntersection(room1, point, roomPosition))
										point.y--;
									point.y--;
									roomPosition.put(room1, point);
								}
								else if (!entry0.right && !entry1.left && entry1.right && entry0.left) {
									Point point = new Point(point1.x + 2, point1.y);
									while (isRoomIntersection(room1, point, roomPosition))
										point.x++;
									point.x++;
									roomPosition.put(room1, point);
								}
								else if (!entry0.left && !entry1.right && entry1.left && entry0.right) {
									Point point = new Point(point1.x - 2, point1.y);
									while (isRoomIntersection(room1, point, roomPosition))
										point.x--;
									point.x--;
									roomPosition.put(room1, point);
								}
								
								else if (!entry0.bottom && !entry1.top) {
									Point point = new Point(point1.x, point1.y + 2);
									while (isRoomIntersection(room1, point, roomPosition))
										point.y++;
									point.y++;
									roomPosition.put(room1, point);
								}
								else if (!entry0.top && !entry1.bottom) {
									Point point = new Point(point1.x, point1.y - 2);
									while (isRoomIntersection(room1, point, roomPosition))
										point.y--;
									point.y--;
									roomPosition.put(room1, point);
								}
								else if (!entry0.right && !entry1.left) {
									Point point = new Point(point1.x + 2, point1.y);
									while (isRoomIntersection(room1, point, roomPosition))
										point.x++;
									point.x++;
									roomPosition.put(room1, point);
								}
								else {
									Point point = new Point(point1.x - 2, point1.y);
									while (isRoomIntersection(room1, point, roomPosition))
										point.x--;
									point.x--;
									roomPosition.put(room1, point);
								}
								
								rooms.add(room1);
							}
						}
			}
		}
		
		player = game.getPlayers().get(0);
	}
	
	static private boolean isRoomIntersection(Room room, Point offset, Map<Room, Point> roomPosition) {
		for (Entry<Room, Point> entry : roomPosition.entrySet())
			if (areRoomsIntersecting(room, offset, entry.getKey(), entry.getValue()))
				return true;
		return false;
	}
	
	static private boolean areRoomsIntersecting(Room room0, Point offset0,
			                             Room room1, Point offset1) {
		Set<Point> points = new HashSet<>();
		for (int y = 0; y < room0.getHeight(); y++)
			for (int x = 0; x < room0.getWidth(); x++)
				if (room0.getGameElement(x, y) != null &&
						!room0.getGameElement(x, y).isTraversable())
					points.add(new Point(offset0.x  + x, offset0.y + y));
		
		for (int y = 0; y < room1.getHeight(); y++)
			for (int x = 0; x < room1.getWidth(); x++)
				if (room1.getGameElement(x, y) != null &&
						!room1.getGameElement(x, y).isTraversable() &&
						points.contains(new Point(offset1.x + x, offset1.y + y)))
					return true;
		
		return false;
	}
	
	private void findDoorEntries(Door door) {
		Room room = door.getPosition().getRoom();
		int x = door.getPosition().getX();
		int y = door.getPosition().getY();
		
		DoorEntry entry = new DoorEntry();
		entry.bottom = y + 1 < room.getHeight() &&
				(room.getGameElement(x, y + 1) == null ||
				 room.getGameElement(x, y + 1).isTraversable());
		entry.right = x + 1 < room.getWidth() &&
				(room.getGameElement(x + 1, y) == null ||
				 room.getGameElement(x + 1, y).isTraversable());
		entry.top = y - 1 >= 0 &&
				(room.getGameElement(x, y - 1) == null ||
				 room.getGameElement(x, y - 1).isTraversable());
		entry.left = x - 1 >= 0 &&
				(room.getGameElement(x - 1, y) == null ||
				 room.getGameElement(x - 1, y).isTraversable());
		doorEntry.put(door, entry);
	}
	
	
	@Override
	public void playerMoved(Player player) {
		repaint();
	}
	
	@Override
	public void elementActivated(GameElement ge) {
		//
	}
	
	@Override
	protected void processKeyEvent(KeyEvent event) {
		if (event.getID() == KeyEvent.KEY_PRESSED) {
			Position pos = player.getPosition();
			GameElement ge = pos.getRoom().getGameElement(pos.getX(), pos.getY());
			
			Position newPos = null;
			switch (event.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					newPos = new Position(pos.getRoom(), pos.getX() - 1, pos.getY());
					break;
				case KeyEvent.VK_UP:
					newPos = new Position(pos.getRoom(), pos.getX(), pos.getY() - 1);
					break;
				case KeyEvent.VK_RIGHT:
					newPos = new Position(pos.getRoom(), pos.getX() + 1, pos.getY());
					break;
				case KeyEvent.VK_DOWN:
					newPos = new Position(pos.getRoom(), pos.getX(), pos.getY() + 1);
					break;
			}
			
			if (newPos != null) {
				if (ge instanceof Door) {
					int x = newPos.getX();
					int y = newPos.getY();
					
					Door door = (Door) ge;
					ge = newPos.getRoom().getGameElement(x, y);
					
					if ((ge != null && !ge.isTraversable()) ||
							x < 0 || x >= newPos.getRoom().getWidth() ||
							y < 0 || y >= newPos.getRoom().getHeight())
						newPos = door.getDoor().getPosition();
				}
				player.move(newPos);
			}
		}
		super.processKeyEvent(event);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		Position playerPos = player.getPosition();
		Point playerOffset = roomPosition.get(playerPos.getRoom());
		Point pos = new Point(
				elementSize / 2 + elementSize * (playerPos.getX() + playerOffset.x),
				elementSize / 2 + elementSize * (playerPos.getY() + playerOffset.y));
		Point offset = new Point(getWidth() / 2 - pos.x, getHeight() / 2 - pos.y);
		
		for (Room room : game.getField().getRooms()) {
			Point roomPos = roomPosition.get(room);
			
			for (int y = 0; y < room.getHeight(); y++)
				for (int x = 0; x < room.getWidth(); x++) {
					Point point = new Point((roomPos.x + x) * elementSize + offset.x,
						                    (roomPos.y + y) * elementSize + offset.y);
					GameElement ge = room.getGameElement(x, y);
					
					if (ge != null)
						drawGameElement(g, ge, point);
					
					if (playerPos.getRoom() == room
							&& playerPos.getX() == x
							&& playerPos.getY() == y)
						drawPlayer(g, player, point);
				}
		}
	}
	
	protected void drawGameElement(Graphics g, GameElement ge, Point p) {
		g.setColor(ge instanceof Door ? Color.GRAY : Color.WHITE);
		g.fillRect(p.x, p.y, elementSize, elementSize);
	}
	
	protected void drawPlayer(Graphics g, Player player, Point p) {
		g.setColor(Color.RED);
		g.fillOval(p.x, p.y, elementSize, elementSize);
	}
}
