package tk3.labyrinth.umundo;

import org.umundo.core.Message;
import org.umundo.core.Node;

import tk3.labyrinth.Game;
import tk3.labyrinth.GameObserver;
import tk3.labyrinth.core.gameelements.GameElement;
import tk3.labyrinth.core.gameelements.IActivatable;
import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.core.shared.Position;

public class God implements GameObserver {
	
	public final static String PREFIX = "tk3.labyrinth.";
	
	private Node node;
	private Game game;
	
	private Connection mainConnection;
	private Connection gameConnection;
	
	
	public God(Game game) {
		this.game = game;
		
		MainGreeter mainGreeter = new MainGreeter();
		MainReceiver mainReceiver = new MainReceiver();
		String mainID = PREFIX + "main";
		mainConnection = new Connection(node, mainID, mainGreeter, mainReceiver);
		
		gameConnection = null;
	}
	
	// 
	public void movePlayer(String id, Position position) {
		game.getPlayer(id).move(position);
	}
	
	
	// Umundo Schicht wird informiert, dass sich etwas im Spiel getan hat: 
	@Override
	public void elementActivated(IActivatable ge) {
		if (ge instanceof GameElement) {
			Message msg = MessageFactory.createElementActivatedMessage(game.getOwnPlayer().getId(), (GameElement) ge, null); //TODO: action=null!?
			gameConnection.send(msg);
		}
	}

	@Override
	public void playerMoved(Player player, Position oldPosition) {
		if(player == game.getOwnPlayer()) {
			Message msg = MessageFactory.createPlayerPositionMessage(player.getId(), player.getPosition());
			gameConnection.send(msg);
		}
	}
	
	
	

}
