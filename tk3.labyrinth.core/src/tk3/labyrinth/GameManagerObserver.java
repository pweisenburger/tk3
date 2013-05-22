package tk3.labyrinth;

import java.util.List;

public interface GameManagerObserver {
	public void newGameStarted(Game game);
	public void gameJoined(Game game);
	public void joinGame(String gameId);
	public void gameListChanged(List<String> gameList);
}
