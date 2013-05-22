package tk3.labyrinth.core.gameelements;

public interface IActivatable {
	void activate(GameElement ge);
	void deactivate(GameElement ge);
	boolean isActive();
}
