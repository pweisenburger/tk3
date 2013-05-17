package tk3.labyrinth;

import tk3.labyrinth.core.gameelements.GameElement;
import tk3.labyrinth.core.player.Player;

public interface Observer {
	
	public void playerMoved(Player player);
	
	public void elementActivated(GameElement ge);
	
	

}
