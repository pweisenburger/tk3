package tk3.labyrinth.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Map;

import javax.swing.JComponent;

import tk3.labyrinth.Game;
import tk3.labyrinth.Observer;
import tk3.labyrinth.core.gameelements.Button;
import tk3.labyrinth.core.gameelements.Door;
import tk3.labyrinth.core.gameelements.GameElement;
import tk3.labyrinth.core.gameelements.Wall;
import tk3.labyrinth.core.gamefield.Room;
import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.core.shared.Position;
import tk3.labyrinth.gui.RoomUtil.DoorEntry;

@SuppressWarnings("serial")
public class GameField extends JComponent implements Observer {
	private Game game;
	private Map<Room, Point> roomPosition;
	private Map<Door, DoorEntry> doorEntry;
	private Player ownPlayer;
	
	static final private int elementSize = 16;
	
	public GameField(Game game) {
		super();
		this.game = game;
		
		game.addObserver(this);
		
		doorEntry = RoomUtil.calculateDoorEntries(game.getField());
		roomPosition = RoomUtil.calculateRoomPosition(game.getField(), doorEntry);
		ownPlayer = game.getOwnPlayer();
	}
	
	@Override
	public void playerMoved(Player player, Position oldPosition) {
		//TODO this should be done in core
		GameElement ge = getGameElement(oldPosition);
		boolean activated = false;
		if (ge instanceof Button) {
			Button button = (Button) ge;
			if (button.getReferencedElement() != null) {
				for (Player p : game.getPlayers())
					if (p.getPosition().equals(oldPosition))  {
						button.getReferencedElement().activate(button);
						activated = true;
						break;
					}
				if (!activated)
					button.getReferencedElement().deactivate(button);
			}
		}
		
		ge = getGameElement(player.getPosition());
		activated = false;
		if (ge instanceof Button) {
			Button button = (Button) ge;
			if (button.getReferencedElement() != null) {
				for (Player p : game.getPlayers())
					if (p.getPosition().equals(player.getPosition()))  {
						button.getReferencedElement().activate(button);
						activated = true;
						break;
					}
				if (!activated)
					button.getReferencedElement().deactivate(button);
			}
		}
		
		repaint();
	}
	
	@Override
	public void elementActivated(GameElement ge) {
		//
	}
	
	@Override
	protected void processKeyEvent(KeyEvent event) {
		if (event.getID() == KeyEvent.KEY_PRESSED) {
			Position pos = ownPlayer.getPosition();
			GameElement ge = getGameElement(pos);
			
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
				ownPlayer.move(newPos);
			}
		}
		super.processKeyEvent(event);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// clear game field
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		// calculate game field offset
		Position playerPos = ownPlayer.getPosition();
		Point playerOffset = roomPosition.get(playerPos.getRoom());
		Point pos = new Point(
				elementSize / 2 + elementSize * (playerPos.getX() + playerOffset.x),
				elementSize / 2 + elementSize * (playerPos.getY() + playerOffset.y));
		Point offset = new Point(getWidth() / 2 - pos.x, getHeight() / 2 - pos.y);
		
		// draw rooms
		for (Room room : game.getField().getRooms()) {
			Point roomPos = roomPosition.get(room);
			
			for (int y = 0; y < room.getHeight(); y++)
				for (int x = 0; x < room.getWidth(); x++) {
					Point point = new Point((roomPos.x + x) * elementSize + offset.x,
						                    (roomPos.y + y) * elementSize + offset.y);
					GameElement ge = room.getGameElement(x, y);
					if (ge != null)
						drawGameElement(g, ge, point);
				}
		}
		
		// draw players
		for (Player player : game.getPlayers()) {
			Point roomPos = roomPosition.get(player.getPosition().getRoom());
			Point point = new Point((roomPos.x + player.getPosition().getX()) * elementSize + offset.x,
				                    (roomPos.y + player.getPosition().getY()) * elementSize + offset.y);
			drawPlayer(g, player, point);
		}
		
		Point roomPos = roomPosition.get(ownPlayer.getPosition().getRoom());
		Point point = new Point((roomPos.x + ownPlayer.getPosition().getX()) * elementSize + offset.x,
			                    (roomPos.y + ownPlayer.getPosition().getY()) * elementSize + offset.y);
		drawPlayer(g, ownPlayer, point);
	}
	
	protected GameElement getGameElement(Position position) {
		return position.getRoom().getGameElement(position.getX(), position.getY());
	}
	
	protected void drawGameElement(Graphics g, GameElement ge, Point p) {
		if (ge instanceof Wall) {
			g.setColor(Color.WHITE);
			g.fillRect(p.x, p.y, elementSize, elementSize);
		}
		
		if (ge instanceof Button) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(p.x, p.y, elementSize, elementSize);
		}
		
		if (ge instanceof Door) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(p.x, p.y, elementSize, elementSize);
			
			if (!((Door) ge).isActive()) {
				g.setColor(Color.WHITE);
				g.drawLine(p.x, p.y, p.x + elementSize, p.y + elementSize);
				g.drawLine(p.x + elementSize, p.y, p.x, p.y + elementSize);
				g.drawPolygon(
						new int[] { p.x + elementSize / 2, p.x + elementSize, p.x + elementSize / 2, p.x},
						new int[] { p.y, p.y + elementSize / 2, p.y + elementSize, p.y + elementSize / 2},
						4);
			}
		}
	}
	
	protected void drawPlayer(Graphics g, Player player, Point p) {
		if (player == ownPlayer) {
			g.setColor(Color.RED);
			g.fillOval(p.x, p.y, elementSize, elementSize);
		}
		else {
			g.setColor(Color.ORANGE);
			g.fillOval(p.x + 1, p.y + 1, elementSize - 2, elementSize - 2);
		}
	}
}
