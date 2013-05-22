package tk3.labyrinth.core.gameelements;

public class Door extends GameElement implements IActivatable {

	private Door door;

	@Override
	public void activate(GameElement ge) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deactivate(GameElement ge) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTraversable() {
		// TODO Auto-generated method stub
		return false;
	}

	public Door getGoal() {
		return door;
	}

	public void setGoal(Door door) {
		this.door = door;
	}
}
