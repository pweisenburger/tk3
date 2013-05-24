package tk3.labyrinth.umundo;

import org.umundo.core.Greeter;
import org.umundo.core.Message;
import org.umundo.core.Publisher;

import tk3.labyrinth.core.player.Player;

public class GameGreeter extends Greeter {
	
	private God manager;
	
	public GameGreeter(God manager) {
		this.manager = manager;
	}
	
	@Override
	public void welcome(Publisher pub, String nodeId, String subId) {
		Player ownPlayer = manager.getGame().getOwnPlayer();
		Message msg = MessageFactory.createPlayerPositionMessageToSubscriber(subId, ownPlayer.getId(), ownPlayer.getPosition());
		pub.send(msg);
	}
	
	@Override
	public void farewell(Publisher arg0, String nodeId, String subId) {
		super.farewell(arg0, nodeId, subId);
		
		//TODO: hier noch was zu tun?
	}
	

}
