package tk3.labyrinth.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Map;

import javax.swing.JComponent;

import tk3.labyrinth.Game;
import tk3.labyrinth.Observer;
import tk3.labyrinth.core.gameelements.Door;
import tk3.labyrinth.core.gameelements.GameElement;
import tk3.labyrinth.core.gamefield.Room;
import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.core.shared.Position;
import tk3.labyrinth.gui.RoomUtil.DoorEntry;

@SuppressWarnings("serial")
public class GameField extends JComponent implements Observer {
	private Game game;
	private Map<Room, Point> roomPosition;
	private Map<Door, DoorEntry> doorEntry;
	private Player player;
	
	static final private int elementSize = 16;
	
	public GameField(Game game) {
		super();
		this.game = game;
		
		game.addObserver(this);
		
		doorEntry = RoomUtil.calculateDoorEntries(game.getField());
		
		roomPosition = RoomUtil.calculateRoomPosition(game.getField(), doorEntry);
		
		player = game.getPlayers().get(0);
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
