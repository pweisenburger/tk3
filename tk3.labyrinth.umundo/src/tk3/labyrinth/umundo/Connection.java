package tk3.labyrinth.umundo;

import org.umundo.core.Greeter;
import org.umundo.core.Node;
import org.umundo.core.Publisher;
import org.umundo.core.Receiver;
import org.umundo.core.Subscriber;

public abstract class Connection {
	
	private String id;
	private Publisher publisher;
	private Subscriber subscriber;
	
	public Connection(Node node, String id, Greeter greeter, Receiver receiver) {
		this.id = id;
		
		publisher = new Publisher(id);
		publisher.setGreeter(greeter);
		
		subscriber = new Subscriber(id, receiver);		
		
		node.addPublisher(publisher);
		node.addSubscriber(subscriber);
	}

}
