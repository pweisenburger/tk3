package tk3.labyrinth.gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JComponent;
import javax.swing.Timer;

import tk3.labyrinth.Game;
import tk3.labyrinth.GameObserver;
import tk3.labyrinth.core.gameelements.Button;
import tk3.labyrinth.core.gameelements.Door;
import tk3.labyrinth.core.gameelements.GameElement;
import tk3.labyrinth.core.gameelements.IActivatable;
import tk3.labyrinth.core.gameelements.Wall;
import tk3.labyrinth.core.gamefield.Room;
import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.core.shared.Position;
import tk3.labyrinth.gui.RoomUtil.DoorEntry;

@SuppressWarnings("serial")
public class GameField extends JComponent implements GameObserver, ActionListener {
	private Game game;
	private Map<Room, Point> roomPosition;
	private Map<Room, Float> roomOpacity;
	private Map<Door, DoorEntry> doorEntry;
	private Map<Player, Point> playerMoving;
	private Player ownPlayer;
	
	private Timer roomAnimation;
	private Timer playerAnimation;
	private Timer testTimer;
	
	static final private int elementSize = 16;
	
	public GameField(Game game) {
		super();
		this.game = game;
		
		game.addObserver(this);
		
		doorEntry = RoomUtil.calculateDoorEntries(game.getField());
		roomPosition = RoomUtil.calculateRoomPosition(game.getField(), doorEntry);
		ownPlayer = game.getOwnPlayer();
		
		roomOpacity = new HashMap<>();
		for (Room room : game.getField().getRooms())
			roomOpacity.put(room, 0.0f);
		
		playerMoving = new HashMap<>();
		for (Player player : game.getPlayers())
			playerMoving.put(player, new Point(0, 0));
		
		roomAnimation = new Timer(20, this);
		roomAnimation.start();
		
		playerAnimation = new Timer(20, this);
		roomAnimation.start();
		
		//TODO: just testing
		{
			testTimer = new Timer(700, this);
			testTimer.start();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		//TODO: just testing
		{
			if (event.getSource() == testTimer) {
				Player player = game.getPlayer("other");
				if (player != null)
					player.move(new Position(
									player.getPosition().getRoom(),
									player.getPosition().getX() == 1 ? 2 : 1,
									player.getPosition().getY()));
			}
		}
		
		// room fade animation
		if (event.getSource() == roomAnimation) {
			boolean change = false;
			for (Entry<Room, Float> entry : roomOpacity.entrySet())
				if (entry.getKey() == ownPlayer.getPosition().getRoom()) {
					entry.setValue(entry.getValue() + 0.05f);
					if (entry.getValue() >= 1.0f)
						entry.setValue(1.0f);
					else
						change = true;
				}
				else if (entry.getValue() > 0.0f) {
					entry.setValue(entry.getValue() - 0.05f);
					if (entry.getValue() <= 0.1f)
						entry.setValue(0.1f);
					else
						change = true;
				}
			
			if (change)
				repaint();
			else
				roomAnimation.stop();
		}
		
		// player movement animation
		if (event.getSource() == playerAnimation) {
			boolean change = false;
			for (Entry<Player, Point> entry : playerMoving.entrySet()) {
				Point point = entry.getValue();
				if (point.x < 0) {
					point.x = Math.min(0, point.x + 4);
					change = true;
				}
				if (point.x > 0) {
					point.x = Math.max(0, point.x - 4);
					change = true;
				}
				if (point.y < 0) {
					point.y = Math.min(0, point.y + 4);
					change = true;
				}
				if (point.y > 0) {
					point.y = Math.max(0, point.y - 4);
					change = true;
				}
			}
			
			if (change)
				repaint();
			else
				playerAnimation.stop();
		}
	}
	
	@Override
	public void playerAdded(Player player) {
		//
	}
	
	@Override
	public void playerRemoved(Player player) {
		//
	}
	
	@Override
	public void playerMoved(Player player, Position oldPosition) {
		if (player == ownPlayer && player.getPosition().getRoom() != oldPosition.getRoom())
			roomAnimation.start();
		
		int dx = oldPosition.getX() - player.getPosition().getX();
		int dy = oldPosition.getY() - player.getPosition().getY();
		
		playerMoving.put(player, Math.abs(dx) + Math.abs(dy) < 2
				? new Point(elementSize * dx, elementSize * dy)
				: new Point(0, 0));
		playerAnimation.start();
		
		repaint();
	}
	
	@Override
	public void elementActivated(IActivatable ge) {
		//
	}
	
	@Override
	protected void processKeyEvent(KeyEvent event) {
		if (event.getID() == KeyEvent.KEY_PRESSED) {
			Position pos = ownPlayer.getPosition();
			GameElement ge = getGameElement(pos);
			
			Position newPos = null;
			switch (event.getKeyCode()) {
				case KeyEvent.VK_ESCAPE:
					game.removePlayer(ownPlayer);
					return;
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
	protected void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// clear game field
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		// calculate game field offset
		Point ownRoomOffset = roomPosition.get(ownPlayer.getPosition().getRoom());
		Point playerOffset = new Point(playerMoving.get(ownPlayer));
		playerOffset.x += elementSize / 2 + elementSize * (ownPlayer.getPosition().getX() + ownRoomOffset.x);
		playerOffset.y += elementSize / 2 + elementSize * (ownPlayer.getPosition().getY() + ownRoomOffset.y);
		
		Point offset = new Point(getWidth() / 2 - playerOffset.x, getHeight() / 2 - playerOffset.y);
		g.translate(offset.x, offset.y);
		
		// draw rooms
		for (Room room : game.getField().getRooms()) {
			Point roomPos = roomPosition.get(room);
			
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, roomOpacity.get(room)));
			
			for (int y = 0; y < room.getHeight(); y++)
				for (int x = 0; x < room.getWidth(); x++) {
					Point point = new Point((roomPos.x + x) * elementSize,
						                    (roomPos.y + y) * elementSize);
					GameElement ge = room.getGameElement(x, y);
					if (ge != null)
						drawGameElement(g, ge, point);
				}
		}
		
		// draw players
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		for (Player player : game.getPlayers())
			if (player.getPosition().getRoom() == ownPlayer.getPosition().getRoom()){
				Point roomPos = roomPosition.get(player.getPosition().getRoom());
				Point pointOffset = playerMoving.get(player);
				Point point = new Point((roomPos.x + player.getPosition().getX()) * elementSize + pointOffset.x,
					                    (roomPos.y + player.getPosition().getY()) * elementSize + pointOffset.y);
				drawPlayer(g, player, point);
			}
		
		Point roomPos = roomPosition.get(ownPlayer.getPosition().getRoom());
		Point pointOffset = playerMoving.get(ownPlayer);
		Point point = new Point((roomPos.x + ownPlayer.getPosition().getX()) * elementSize + pointOffset.x,
			                    (roomPos.y + ownPlayer.getPosition().getY()) * elementSize + pointOffset.y);
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
			
			if (ge.getPosition().getRoom() == ownPlayer.getPosition().getRoom() &&
					!((Door) ge).isActive()) {
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
