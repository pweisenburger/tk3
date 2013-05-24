package tk3.labyrinth.umundo;

import org.umundo.core.Message;
import org.umundo.core.Receiver;

import tk3.labyrinth.Game;
import static tk3.labyrinth.umundo.MessageFactory.*;

public class MainReceiver extends Receiver {

	private UmundoManager manager;
	
	public MainReceiver(UmundoManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void receive(Message msg) {
		Game game = manager.getGame();
		switch(msg.getMeta(KEY_TYPE)) {
		case MSG_GET_GAME_INFO:
			Message answer = createGameInfoMessage(game.getOwnPlayer().getId(),game.getId());
			// TODO: möglicherweise nicht an alle schicken
			manager.getMainConnection().send(answer);
			break;
		case MSG_GAME_INFO:
			manager.getGameManager().addGame(msg.getMeta(KEY_GAME_ID));
			break;
		}
		super.receive(msg);
	}
	
}
