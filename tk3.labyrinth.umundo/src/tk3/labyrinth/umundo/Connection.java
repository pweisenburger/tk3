package tk3.labyrinth.umundo;

import org.umundo.core.Greeter;
import org.umundo.core.Message;
import org.umundo.core.Node;
import org.umundo.core.Publisher;
import org.umundo.core.Receiver;
import org.umundo.core.Subscriber;

public class Connection {
	
	private String id;
	private Publisher publisher;
	private Subscriber subscriber;
	private Node node;
	
	
	public Connection(Node node, String id, Greeter greeter, Receiver receiver) {
		this.id = id;
		this.node = node;
		
		publisher = new Publisher(id);
		publisher.setGreeter(greeter);
		
		subscriber = new Subscriber(id, receiver);		
		
		node.addPublisher(publisher);
		node.addSubscriber(subscriber);
	}
	
	public void send(Message msg) {
		publisher.send(msg);
	}
	
	public void close() {
		node.removePublisher(publisher);
		node.removeSubscriber(subscriber);
	}
	
	public String getId() {
		return id;
	}

	public String getSubscriberUUID() {
		return subscriber.getUUID();
	}

}
