package tk3.labyrinth.umundo;

import java.io.IOException;

import org.umundo.core.Greeter;
import org.umundo.core.Message;
import org.umundo.core.Publisher;

import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.map.MapFacade;

public class GameGreeter extends Greeter {
	
	private UmundoManager manager;
	
	private MapFacade mapFacade = new MapFacade();
	
	public GameGreeter(UmundoManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void welcome(Publisher pub, String nodeId, String subId) {
		if(manager.getGame() != null) {
			Message msg;
			Player ownPlayer = manager.getGame().getOwnPlayer();
			
			if (manager.getGame() != null) {
				String mapName = manager.getGame().getField().getName();
				String mapDescription = null;
				try {
					mapDescription = mapFacade.getMapAsString(mapName);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					return;
				}
				msg = MessageFactory.createMapInfoMessageToSubscriber(subId, ownPlayer.getId(), mapName, mapDescription);
				pub.send(msg);
				
				System.out.println("SENDE MAP_INFO");
			
				msg = MessageFactory.createPlayerPositionMessageToSubscriber(subId, ownPlayer.getId(), ownPlayer.getPosition());
				pub.send(msg);
				
				System.out.println("SENDE PLAYER_POSITION_MESSAGE");
			}
		}		
	}
	
	@Override
	public void farewell(Publisher arg0, String nodeId, String subId) {
		String playerId = manager.getSubIDToPlayerIDMap().get(subId);
		if (playerId != null) {
			Player player = manager.getGame().getPlayer(playerId);
			manager.getGame().removePlayer(player);
			manager.getSubIDToPlayerIDMap().remove(subId);
		}
	}
	

}
