package tk3.labyrinth.umundo;

import org.umundo.core.Message;
import org.umundo.core.Receiver;

public class MainReceiver extends Receiver {

	private God manager;
	
	public MainReceiver(God manager) {
		this.manager = manager;
	}
	
	@Override
	public void receive(Message msg) {
		// TODO Auto-generated method stub
		super.receive(msg);
	}
	
}
