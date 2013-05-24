package tk3.labyrinth.umundo;

import java.util.ArrayList;
import java.util.Arrays;

import org.umundo.core.Message;
import org.umundo.core.Receiver;

import tk3.labyrinth.Game;
import tk3.labyrinth.GameManager;
import tk3.labyrinth.core.gamefield.Field;
import tk3.labyrinth.core.gamefield.Room;
import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.core.shared.Position;

public class GameReceiver extends Receiver {
	
	private UmundoManager manager;
	
	public GameReceiver(UmundoManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void receive(Message msg) {
		switch(msg.getMeta(MessageFactory.KEY_TYPE)) {
		case MessageFactory.MSG_ELEMENT_ACTIVATED:
			System.out.println("EMPFANGEN ELEMENT_ACTIVATED");
			dispatchElementActivated(msg.getMeta(MessageFactory.KEY_SENDER_ID), msg.getMeta(MessageFactory.KEY_POS_ROOM), 
						Integer.parseInt(msg.getMeta(MessageFactory.KEY_POS_X)), Integer.parseInt(msg.getMeta(MessageFactory.KEY_POS_Y)),
						msg.getMeta(MessageFactory.KEY_ACTION));
			break;
			
		case MessageFactory.MSG_PLAYER_POSITION:
			System.out.println("EMPFANGEN PLAYER_POSITION (von '" + msg.getMeta(MessageFactory.KEY_SENDER_ID) + "')");
			dispatchPlayerPosition(msg.getMeta(MessageFactory.KEY_SENDER_ID), msg.getMeta(MessageFactory.KEY_SENDER_SUBSCRIBER_ID), msg.getMeta(MessageFactory.KEY_POS_ROOM), 
						Integer.parseInt(msg.getMeta(MessageFactory.KEY_POS_X)), Integer.parseInt(msg.getMeta(MessageFactory.KEY_POS_Y)));
			break;
			
		case MessageFactory.MSG_MAP_INFO:
			System.out.println("EMPFANGEN MAP_INFO");
			dispatchGameInfo(msg.getMeta(MessageFactory.KEY_SENDER_ID), msg.getMeta(MessageFactory.KEY_MAP_ID),
					msg.getMeta(MessageFactory.KEY_MAP_DESCRIPTION));
			
		default:
			//not interested
		}
	}

	private void dispatchElementActivated(String senderId, String posRoom, int posX, int posY, String action) {
		//TODO:
		System.out.println("ELEMENT ACTIVATED: " + senderId + ", " + posRoom + ", " + posX + ", " + posY + ", " + action);
	}
	
	private void dispatchPlayerPosition(String senderId, String senderSubId, String posRoom, int posX, int posY) {
		if(manager.getGame() != null) {
			manager.getSubIDToPlayerIDMap().put(senderSubId, senderId);
			
			Room room = null;
			
			for(Room r : manager.getGame().getField().getRooms()) {
				if(r.getId().equals(posRoom)) {
					room = r;
				}
			}
			
			if(room == null) {
				System.err.println("DER RAUM DARF EIGENTLICH NICHT NULL SEIN.");
			} else {
				manager.getGame().getPlayer(senderId).move(new Position(room, posX, posY));
			}
		} //ansonsten warten, bis die Map gekommen ist und das das Spiel angelegt wurde
	}
	
	private void dispatchGameInfo(String SenderId, String mapId, String mapDescription) {
		if(manager.getGame() == null) { //andernfalls haben wir die Karte schon bekommen
			String gameId = manager.getGameConnection().getId().substring(manager.PREFIX.length());
			Field field = null; // TODO parser aufrufen
			Position position = null; // TODO eigene Position bestimmen
			Player ownPlayer = new Player("xy", position); // TODO Namen herausfinden
			
			Game joinedGame = new Game(gameId, field, new ArrayList<Player>(Arrays.asList(ownPlayer))); //TODO eigenen Spieler festlegen
			
			
			manager.getGameManager().joinGame(joinedGame);
			// der Rest wird vom UmundoManager in gameJoined durchgeführt
		}
	}
	
	
	
}
