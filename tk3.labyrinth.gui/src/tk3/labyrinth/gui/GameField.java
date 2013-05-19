package tk3.labyrinth.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;

import tk3.labyrinth.Game;
import tk3.labyrinth.Observer;
import tk3.labyrinth.core.gameelements.GameElement;
import tk3.labyrinth.core.gamefield.Room;
import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.core.shared.Position;

@SuppressWarnings("serial")
public class GameField extends JComponent implements Observer {
	private Game game;
	private Map<Room, Point> roomPosition;
	private Player player;
	
	static final private int elementSize = 16;
	
	public GameField(Game game) {
		super();
		this.game = game;
		
		game.addObserver(this);
		
		roomPosition = new HashMap<>();
		for (Room room : game.getField().getRooms())
			roomPosition.put(room, new Point(0, 0));
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
			switch (event.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.move(new Position(pos.getRoom(), pos.getX() - 1, pos.getY()));
					break;
				case KeyEvent.VK_UP:
					player.move(new Position(pos.getRoom(), pos.getX(), pos.getY() - 1));
					break;
				case KeyEvent.VK_RIGHT:
					player.move(new Position(pos.getRoom(), pos.getX() + 1, pos.getY()));
					break;
				case KeyEvent.VK_DOWN:
					player.move(new Position(pos.getRoom(), pos.getX(), pos.getY() + 1));
					break;
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
					Point point = new Point(roomPos.x + offset.x + x * elementSize,
						    roomPos.y + offset.y + y * elementSize);
					GameElement ge = room.getGameElement(x, y);
					
					if (ge != null) {
						g.setColor(Color.WHITE);
						g.fillRect(point.x, point.y, elementSize, elementSize);
					}
					
					if (playerPos.getRoom() == room
							&& playerPos.getX() == x
							&& playerPos.getY() == y) {
						g.setColor(Color.RED);
						g.fillOval(point.x, point.y, elementSize, elementSize);
					}
				}
		}
	}
}
