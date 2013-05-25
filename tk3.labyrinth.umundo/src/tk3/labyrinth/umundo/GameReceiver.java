package tk3.labyrinth.umundo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.umundo.core.Message;
import org.umundo.core.Receiver;

import tk3.labyrinth.Game;
import tk3.labyrinth.core.gameelements.Start;
import tk3.labyrinth.core.gamefield.Field;
import tk3.labyrinth.core.gamefield.Room;
import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.core.shared.Position;
import tk3.labyrinth.map.MapFacade;
import tk3.labyrinth.map.SyntaxException;

public class GameReceiver extends Receiver {
	
	private static Logger logger = LoggerFactory.getLogger(GameReceiver.class);
	
	private UmundoManager manager;
	
	private MapFacade mapFacade;
	
	public GameReceiver(UmundoManager manager) {
		this.manager = manager;
		this.mapFacade = new MapFacade();
	}
	
	@Override
	public void receive(Message msg) {
		switch(msg.getMeta(MessageFactory.KEY_TYPE)) {
		case MessageFactory.MSG_ELEMENT_ACTIVATED:
			dispatchElementActivated(msg.getMeta(MessageFactory.KEY_SENDER_ID), msg.getMeta(MessageFactory.KEY_POS_ROOM), 
						Integer.parseInt(msg.getMeta(MessageFactory.KEY_POS_X)), Integer.parseInt(msg.getMeta(MessageFactory.KEY_POS_Y)),
						msg.getMeta(MessageFactory.KEY_ACTION));
			break;
			
		case MessageFactory.MSG_PLAYER_POSITION:
			dispatchPlayerPosition(msg.getMeta(MessageFactory.KEY_SENDER_ID), msg.getMeta(MessageFactory.KEY_SENDER_SUBSCRIBER_ID), msg.getMeta(MessageFactory.KEY_POS_ROOM), 
						Integer.parseInt(msg.getMeta(MessageFactory.KEY_POS_X)), Integer.parseInt(msg.getMeta(MessageFactory.KEY_POS_Y)));
			break;
			
		case MessageFactory.MSG_MAP_INFO:
			dispatchGameInfo(msg.getMeta(MessageFactory.KEY_SENDER_ID), msg.getMeta(MessageFactory.KEY_MAP_ID),
					msg.getMeta(MessageFactory.KEY_MAP_DESCRIPTION));
		case MessageFactory.MSG_GET_MAP_INFO:
			dispatchGetGameInfo(msg.getMeta(MessageFactory.KEY_SENDER_ID),msg.getMeta(MessageFactory.KEY_SENDER_SUBSCRIBER_ID));
		default:
			//not interested
		}
	}

	private void dispatchGetGameInfo(String senderId, String senderSubId) {
		if(manager.getGame() != null) {
			Message msg;
			Player ownPlayer = manager.getGame().getOwnPlayer();
				
			if (manager.getGame().getPlayer(senderId) == null) {
			
			String mapName = manager.getGame().getField().getName();
			String mapDescription = null;
			try {
				mapDescription = mapFacade.getMapAsString(mapName);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return;
			}
			msg = MessageFactory.createMapInfoMessageToSubscriber(senderSubId, ownPlayer.getId(), mapName, mapDescription);
			manager.getGameConnection().send(msg);
		
			msg = MessageFactory.createPlayerPositionMessageToSubscriber(senderSubId, ownPlayer.getId(), manager.getGameConnection().getSubscriberUUID(), ownPlayer.getPosition());
			manager.getGameConnection().send(msg);
			}
			
			else {
				msg = MessageFactory.createMapInfoMessageToSubscriber(senderSubId, manager.getPlayerId(), "", "");
				manager.getGameConnection().send(msg);
			}
		}
	}

	private void dispatchElementActivated(String senderId, String posRoom, int posX, int posY, String action) {
		//System.out.println("ELEMENT ACTIVATED: " + senderId + ", " + posRoom + ", " + posX + ", " + posY + ", " + action);
	}
	
	private void dispatchPlayerPosition(String senderId, String senderSubId, String posRoom, int posX, int posY) {
		if(manager.getGame() != null) {
			
			logger.debug("PUT: SubId='{}' senderId='{}'", senderSubId, senderId);
			
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
				Player player = manager.getGame().getPlayer(senderId);
				Position pos = new Position(room, posX, posY);
				if(player != null) player.move(pos);
				else {
					player = new Player(senderId, pos);
					manager.getGame().addPlayer(player);
				}
			}
		} //ansonsten warten, bis die Map gekommen ist und das das Spiel angelegt wurde
	}
	
	private void dispatchGameInfo(String senderId, String mapId, String mapDescription) {
		/*
		//wenn ein anderer spieler denselben Namen wie ich hat, schmeisse mich raus
		if(senderId.equals(manager.getPlayerId())) {
			logger.warn("Doppelter Benutzername: {}", senderId);
			//manager.getGameManager().userNameAlreadyUsed(); //TODO
			return;
		}
		*/
		if (mapId.isEmpty() && mapDescription.isEmpty()) {
			manager.getGameManager().joinGame(null);
		}
		
		else if(manager.getGame() == null) { //andernfalls haben wir die Karte schon bekommen
			String gameId = manager.getGameConnection().getId().substring(UmundoManager.PREFIX.length());
			
			Field field = null;
			try {
				field = mapFacade.addMap(mapDescription);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			} catch (SyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			
			Start start = field.getStart();
			Player ownPlayer = new Player(manager.getPlayerId(), start.getPosition());
			
			Game joinedGame = new Game(gameId, field, new ArrayList<Player>(Arrays.asList(ownPlayer)));
			joinedGame.setOwnPlayer(ownPlayer);
			
			manager.getGameManager().joinGame(joinedGame);
			// der Rest wird vom UmundoManager in gameJoined durchgeführt
		}
	}
	
	
	
}
