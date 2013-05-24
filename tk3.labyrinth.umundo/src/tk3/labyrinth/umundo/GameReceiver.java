package tk3.labyrinth.umundo;

import org.umundo.core.Message;
import org.umundo.core.Receiver;

public class GameReceiver extends Receiver {
	
	private God manager;
	
	public GameReceiver(God manager) {
		this.manager = manager;
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
			dispatchPlayerPosition(msg.getMeta(MessageFactory.KEY_SENDER_ID), msg.getMeta(MessageFactory.KEY_POS_ROOM), 
						Integer.parseInt(msg.getMeta(MessageFactory.KEY_POS_X)), Integer.parseInt(msg.getMeta(MessageFactory.KEY_POS_Y)));
			break;
			
		default:
			//not interested
		}
	}

	private void dispatchElementActivated(String senderId, String posRoom, int posX, int posY, String action) {
		
	}
	
	private void dispatchPlayerPosition(String senderId, String posRoom, int posX, int posY) {
		
	}
	
}
