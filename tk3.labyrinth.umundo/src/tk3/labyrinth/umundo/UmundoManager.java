package tk3.labyrinth.umundo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.umundo.core.Message;
import org.umundo.core.Node;

import tk3.labyrinth.Game;
import tk3.labyrinth.GameManager;
import tk3.labyrinth.GameManagerObserver;
import tk3.labyrinth.GameObserver;
import tk3.labyrinth.core.gameelements.GameElement;
import tk3.labyrinth.core.gameelements.IActivatable;
import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.core.shared.Position;

public class UmundoManager implements GameObserver, GameManagerObserver {
	
	public final static String PREFIX = "tk3.labyrinth.";
	
	private Node node;
	private GameManager gameManager;
	private Game game; //<-- brauchen wir das hier?
	
	private Connection mainConnection;
	private Connection gameConnection;
	
	/**
	 * map subID --> playerID
	 */
	private HashMap<String,String> players = new HashMap<String,String>();

	public UmundoManager(GameManager gameManager) {
		this.gameManager = gameManager;

		gameManager.addObserver(this);
		
		this.node = new Node();
		
		MainGreeter mainGreeter = new MainGreeter(this);
		MainReceiver mainReceiver = new MainReceiver(this);
		String mainID = PREFIX + "main";
		mainConnection = new Connection(node, mainID, mainGreeter, mainReceiver);
		
		gameConnection = null;
	}
	
	public void close() {
		if(gameConnection != null) gameConnection.close();
		mainConnection.close();
		node.delete();
	}
	
	public GameManager getGameManager() {
		return gameManager;
	}
	
	public Game getGame() {
		return game;
	}

	public Connection getMainConnection() {
		return mainConnection;
	}

	public Connection getGameConnection() {
		return gameConnection;
	}

	public HashMap<String, String> getSubIDToPlayerIDMap() {
		return players;
	}
	
	// 
	public void movePlayer(String id, Position position) {
		game.getPlayer(id).move(position);
	}
	
	
	
	// Umundo Schicht wird informiert, dass sich etwas im Spiel getan hat: 
	@Override
	public void elementActivated(IActivatable ge) {
		if (ge instanceof GameElement) {
			Message msg = MessageFactory.createElementActivatedMessage(game.getOwnPlayer().getId(), (GameElement) ge, ""); //TODO: action=null!?
			gameConnection.send(msg);
		}
	}

	@Override
	public void playerMoved(Player player, Position oldPosition) {
		if(player == game.getOwnPlayer()) {
			Message msg = MessageFactory.createPlayerPositionMessage(player.getId(), gameConnection.getSubscriberUUID(), player.getPosition());
			gameConnection.send(msg);
		}
	}

	@Override
	public void playerAdded(Player player) {
		// TODO: hier wirklich nichts tun?	
		
	}

	@Override
	public void playerRemoved(Player player) {
		// TODO: hier wirklich nichts tun?	
		
	}

	@Override
	public void newGameStarted(Game game) {
		
		this.game = game;

		game.addObserver(this);
		gameConnection = new Connection(node, PREFIX + game.getId(), new GameGreeter(this), new GameReceiver(this));
		
		//auf main nachricht verschicken, dass wir ein neues Spiel gestartet haben
		Message msg = MessageFactory.createGameInfoMessage(game.getOwnPlayer().getId(), game.getId());
		mainConnection.send(msg);
		System.out.println("GESENDET: NEW GAME STARTED auf main");
	}

	@Override
	public void gameJoined(Game game) {
		this.game = game;
		game.addObserver(this);

		if(gameConnection == null) { // TODO: brauchen wir das?
			gameConnection = new Connection(node, PREFIX + game.getId(), new GameGreeter(this), new GameReceiver(this));
		}
		
		//eigene position verschicken --> GREETER
	}

	@Override
	public void gameLeft(Game game) {
		gameConnection.close();
		gameConnection = null;
		game.removeObserver(this);
		this.game = null;
		players.clear();
		
		gameManager.setGames(new HashSet<String>());
		Message getGameInfoMsg = MessageFactory.createGetGameInfoMessage("X"); // TODO: senderId
		mainConnection.send(getGameInfoMsg);
	}

	@Override
	public void joinGame(String gameId) {
		gameConnection = new Connection(node, PREFIX + gameId, new GameGreeter(this), new GameReceiver(this));
	}

	@Override
	public void gameListChanged(Set<String> gameList) {
		// TODO: hier wirklich nichts tun?		
	}
	
	
	

}
