package tk3.labyrinth.umundo;

import org.umundo.core.Greeter;
import org.umundo.core.Message;
import org.umundo.core.Publisher;

import tk3.labyrinth.Game;

public class MainGreeter extends Greeter {

	private UmundoManager manager;
	
	public MainGreeter(UmundoManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void welcome(Publisher pub, String nodeId, String subId) {
		//wenn ich in einem Spiel drinnen bin, andere informieren in welchem
		Game game = manager.getGame();
		if(game != null) {
			Message msg = MessageFactory.createGameInfoMessageToSubscriber(subId, game.getOwnPlayer().getId(), game.getId());
			pub.send(msg);
		}
	}
	
	@Override
	public void farewell(Publisher arg0, String nodeId, String subId) {
		super.farewell(arg0, nodeId, subId);
		
		//TODO: hier noch was zu tun?
	}
	
	
}
