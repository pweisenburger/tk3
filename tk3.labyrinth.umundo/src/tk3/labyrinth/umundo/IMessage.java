package tk3.labyrinth.umundo;

public interface IMessage {
	
	/**
	 * Neues Spiel wird gestartet 
	 */
	public final static String MSG_NEW_GAME = "newgame";
	
	public final static String MSG_PLAYER_POSITION = "playerposition";
	
	/**
	 * Spieler informiert, in welchem Spiel er drinnen ist
	 */
	public final static String MSG_GAME_INFO = "gameinfo";
	
	/**
	 * Spieler fragt andere Spieler nach ihren aktuellen Spielen ab, diese antworten mit MSG_GAME_INFO
	 */
	public final static String MSG_GET_GAME_INFO ="getgameinfo";
	
	public final static String MSG_ELEMENT_ACTIVATED = "elementactivated";

}
