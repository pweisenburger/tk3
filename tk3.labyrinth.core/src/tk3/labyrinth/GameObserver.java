package tk3.labyrinth;

import tk3.labyrinth.core.gameelements.IActivatable;
import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.core.shared.Position;

public interface GameObserver {
	public void playerAdded(Player player);
	public void playerRemoved(Player player);
	public void playerMoved(Player player, Position oldPosition);
	public void elementActivated(IActivatable ge);
}
