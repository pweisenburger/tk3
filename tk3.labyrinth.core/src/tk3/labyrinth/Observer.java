package tk3.labyrinth;

import tk3.labyrinth.core.gameelements.GameElement;
import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.core.shared.Position;

public interface Observer {
	public void playerMoved(Player player, Position oldPosition);
	public void elementActivated(GameElement ge);
}
