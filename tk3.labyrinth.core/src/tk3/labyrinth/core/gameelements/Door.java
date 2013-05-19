package tk3.labyrinth.core.gameelements;

public class Door extends GameElement implements IActivatable {
	private Door door;
	private boolean active;
	
	public void initDoor(Door door) {
		if (this.door != null)
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
	}
	
	@Override
	public void deactivate(GameElement ge) {
		active = false;
	}
	
	@Override
	public boolean isActive() {
		return active;
	}
}
