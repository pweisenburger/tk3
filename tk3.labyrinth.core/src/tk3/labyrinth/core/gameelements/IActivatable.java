package tk3.labyrinth.core.gameelements;

public interface IActivatable {

	public void activate(GameElement ge);

	public void deactivate(GameElement ge);

	public boolean isActive();

}
