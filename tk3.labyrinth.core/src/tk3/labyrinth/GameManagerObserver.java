package tk3.labyrinth;

import java.util.Set;

public interface GameManagerObserver {
	public void newGameStarted(Game game);
	public void gameJoined(Game game);
	public void gameLeft(Game game);
	public void joinGame(String gameId);
	public void gameListChanged(Set<String> gameList);
}