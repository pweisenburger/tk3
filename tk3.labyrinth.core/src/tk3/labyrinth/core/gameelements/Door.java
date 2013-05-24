package tk3.labyrinth.core.gameelements;

public class Door extends GameElement implements IActivatable {
	private Door door;
	private boolean active;
	private boolean alwaysOpen = true;
	
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
		active = true;
		door.active = true;
	}
	
	@Override
	public void deactivate(GameElement ge) {
		active = false;
		door.active = false;
	}
	
	@Override
	public boolean isActive() {
		if (alwaysOpen) {
			return true;
		}
		return active;
	}
	
	public Door getDoor() {
		return door;
	}

	public void setAlwaysOpen(boolean b) {
		alwaysOpen  = b;
	}
}
