package tk3.labyrinth.core.gameelements;

import java.util.HashSet;
import java.util.Set;

public class Door extends GameElement implements IActivatable {
	private Door door;
	private boolean alwaysOpen = true;
	private Set<GameElement> active = new HashSet<>();
	
	public void initDoor(Door door) {
		if (this.door != null && this.door != door)
			throw new UnsupportedOperationException("Door already set");
		this.door = door;
	}
	
	@Override
	public boolean isTraversable() {
		return isActive();
	}
	
	@Override
	public void activate(GameElement ge) {
		active.add(ge);
		door.active.add(ge);
	}
	
	@Override
	public void deactivate(GameElement ge) {
		active.remove(ge);
		door.active.remove(ge);
	}
	
	@Override
	public boolean isActive() {
		return alwaysOpen || !active.isEmpty();
	}
	
	public Door getDoor() {
		return door;
	}

	public void setAlwaysOpen(boolean b) {
		alwaysOpen  = b;
	}
}
