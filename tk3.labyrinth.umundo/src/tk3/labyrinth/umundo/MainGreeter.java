package tk3.labyrinth.umundo;

import org.umundo.core.Greeter;
import org.umundo.core.Publisher;

public class MainGreeter extends Greeter {

	private God manager;
	
	public MainGreeter(God manager) {
		this.manager = manager;
	}
	
	@Override
	public void welcome(Publisher arg0, String nodeId, String subId) {
		// TODO Auto-generated method stub
		super.welcome(arg0, nodeId, subId);
	}
	
	@Override
	public void farewell(Publisher arg0, String nodeId, String subId) {
		// TODO Auto-generated method stub
		super.farewell(arg0, nodeId, subId);
	}
	
	
}
