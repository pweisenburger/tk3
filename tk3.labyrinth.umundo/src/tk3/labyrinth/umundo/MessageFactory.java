package tk3.labyrinth.umundo;

import org.umundo.core.Message;

import tk3.labyrinth.core.gameelements.GameElement;
import tk3.labyrinth.core.shared.Position;

public class MessageFactory {
	
	public final static String MSG_PLAYER_POSITION = "playerposition";
	
	/**
	 * Spieler informiert, in welchem Spiel er drinnen ist
	 */
	public final static String MSG_GAME_INFO = "gameinfo";
	
	/**
	 * Spieler fragt andere Spieler nach ihren aktuellen Spielen ab, diese antworten mit MSG_GAME_INFO
	 */
	public final static String MSG_GET_GAME_INFO ="getgameinfo";
	
	public final static String MSG_MAP_INFO = "mapinfo";
	
	
	
	public final static String MSG_ELEMENT_ACTIVATED = "elementactivated";
	
	public final static String KEY_TYPE = "TYPE";
	
	public final static String KEY_POS_ROOM = "POS_ROOM";
	
	public final static String KEY_POS_X = "POS_X";
	
	public final static String KEY_POS_Y = "POS_Y";
	
	public final static String KEY_GAME_ID = "GAME_ID";
	
	public final static String KEY_SENDER_ID = "SENDER_ID";
	
	public final static String KEY_MAP_ID = "MAP_ID";
	
	public final static String KEY_MAP_DESCRIPTION = "MAP_DESCRIPTION";
	
	public final static String KEY_ACTION = "ACTION";

	public static Message createGameInfoMessage(String senderID, String gameID) {
		Message msg = new Message();
		msg.putMeta(KEY_TYPE, MSG_GAME_INFO);
		msg.putMeta(KEY_SENDER_ID, senderID);
		msg.putMeta(KEY_GAME_ID, gameID);
		return msg;
	}
	
	public static Message createGameInfoMessageToSubscriber(String subscriberSubID, String senderID, String gameID) {
		Message msg = Message.toSubscriber(subscriberSubID);
		msg.putMeta(KEY_TYPE, MSG_GAME_INFO);
		msg.putMeta(KEY_SENDER_ID, senderID);
		msg.putMeta(KEY_GAME_ID, gameID);
		return msg;
	}
	
	public static Message createPlayerPositionMessage(String senderID, Position position) {
		Message msg = new Message();
		msg.putMeta(KEY_TYPE, MSG_PLAYER_POSITION);
		msg.putMeta(KEY_SENDER_ID, senderID);
		msg.putMeta(KEY_POS_ROOM, position.getRoom().getId());
		msg.putMeta(KEY_POS_X, Integer.toString(position.getX()));
		msg.putMeta(KEY_POS_Y, Integer.toString(position.getY()));
		return msg;
	}
	
	public static Message createPlayerPositionMessageToSubscriber(String subscriberSubID, String senderID, Position position) {
		Message msg = Message.toSubscriber(subscriberSubID);
		msg.putMeta(KEY_TYPE, MSG_PLAYER_POSITION);
		msg.putMeta(KEY_SENDER_ID, senderID);
		msg.putMeta(KEY_POS_ROOM, position.getRoom().getId());
		msg.putMeta(KEY_POS_X, Integer.toString(position.getX()));
		msg.putMeta(KEY_POS_Y, Integer.toString(position.getY()));
		return msg;
	}
	
	public static Message createGetGameInfoMessage(String senderID) {
		Message msg = new Message();
		msg.putMeta(KEY_TYPE, MSG_GET_GAME_INFO);
		msg.putMeta(KEY_SENDER_ID, senderID);
		return msg;
	}
	
	public static Message createElementActivatedMessage(String senderID, GameElement ge, String action) {
		Message msg = new Message();
		msg.putMeta(KEY_TYPE, MSG_ELEMENT_ACTIVATED);
		msg.putMeta(KEY_SENDER_ID, senderID);
		msg.putMeta(KEY_POS_ROOM, ge.getPosition().getRoom().getId());
		msg.putMeta(KEY_POS_X, Integer.toString(ge.getPosition().getX()));
		msg.putMeta(KEY_POS_Y, Integer.toString(ge.getPosition().getY()));
		msg.putMeta(KEY_ACTION, action);
		return msg;
	}
	
	public static Message createMapInfoMessage(String senderID, String mapID, String mapDescription) {
		Message msg = new Message();
		msg.putMeta(KEY_TYPE, MSG_MAP_INFO);
		msg.putMeta(KEY_SENDER_ID, senderID);
		msg.putMeta(KEY_MAP_ID, mapID);
		msg.putMeta(KEY_MAP_DESCRIPTION, mapDescription);
		return msg;
	}
	
	public static Message createMapInfoMessageToSubscriber(String SubscriberID, String senderID, String mapID, String mapDescription) {
		Message msg = Message.toSubscriber(SubscriberID);
		msg.putMeta(KEY_TYPE, MSG_MAP_INFO);
		msg.putMeta(KEY_SENDER_ID, senderID);
		msg.putMeta(KEY_MAP_ID, mapID);
		msg.putMeta(KEY_MAP_DESCRIPTION, mapDescription);
		return msg;
	}
}
