package tk3.labyrinth.gui;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.Timer;

import tk3.labyrinth.Game;
import tk3.labyrinth.GameManager;
import tk3.labyrinth.GameManagerObserver;
import tk3.labyrinth.core.gamefield.Field;
import tk3.labyrinth.core.player.Player;
import tk3.labyrinth.map.MapFacade;
import tk3.labyrinth.map.SyntaxException;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements ActionListener, GameManagerObserver {
	private MapFacade mapFacade;
	private GameManager gameManager;
	private SpringLayout layout;
	private BlackPanel blackPanel;
	private Timer animation;
	private ListInputView gameList;
	private ListInputView mapList;
	private JComponent animationTarget;
	private String playerName;
	
	public GameFrame(GameManager manager) {
		mapFacade = new MapFacade();
		gameManager = manager;
		playerName = System.getProperty("user.name");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(640, 480));
		setMinimumSize(new Dimension(400, 400));
		setFocusable(true);
		setVisible(true);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(layout = new SpringLayout());
  	
		blackPanel = new BlackPanel();
		getContentPane().add(blackPanel);
		
		gameList = new ListInputView() {
			protected void listItemClicked(String item) {
				gameManager.joinGame(item, playerName = getInputText());
			}
			
			protected void buttonClicked() {
				playerName = getInputText();
				mapList.setInputText(playerName + "'s game");
				animateTo(mapList);
			}
		};
		gameList.setInputDesc("Player name: ");
		gameList.setInputText(playerName);
		gameList.setButtonText("New Game");
		
		mapList = new ListInputView() {
			protected void listItemClicked(String item) {
				if (gameManager.getGames().contains(getInputText()))
					animateTo(gameList);
				else
					try {
	
						Field field = mapFacade.getMap(item);
						Player player = new Player(playerName, field.getStart().getPosition());
						Game game = new Game(getInputText(), field, Arrays.asList(player));
						game.setOwnPlayer(player);
						gameManager.startNewGame(game);
					} catch (IOException | SyntaxException e) {
						e.printStackTrace();
					}
			}
			
			protected void buttonClicked() {
				animateTo(gameList);
			}
		};
		mapList.setInputDesc("Game name: ");
		mapList.setButtonText("Back");
		
		List<String> maps = mapFacade.getMapList();
		if (maps.isEmpty())
			mapList.setList(Collections.singletonList("(no maps)"), false);
		else
			mapList.setList(maps, true);
		
		layout.putConstraint(SpringLayout.HEIGHT, blackPanel, 0,
				             SpringLayout.HEIGHT, getContentPane());
		layout.putConstraint(SpringLayout.WIDTH, blackPanel, 0,
				             SpringLayout.WIDTH, getContentPane());
		
		pack();
		
		animation = new Timer(20, this);
		animateTo(gameList);
		
		gameListChanged(Collections.<String>emptySet());
		gameManager.addObserver(this);
	}
	
	@Override
	public void newGameStarted(Game game) {
		animateTo(new GameField(game));
	}
	
	@Override
	public void gameJoined(Game game) {
		animateTo(new GameField(game));
	}
	
	@Override
	public void gameLeft(Game game) {
		animateTo(gameList);
	}
	
	@Override
	public void joinGame(String gameId, String playerId) {
		//
	}
	
	@Override
	public void gameListChanged(Set<String> games) {
		if (games.isEmpty())
			gameList.setList(Collections.singletonList("(no games)"), false);
		else {
			List<String> tempList = new ArrayList<String>(games);
			gameList.setList(tempList, true);
		}
	}
	
	public void animateTo(JComponent target) {
		animationTarget = target;
		animation.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (blackPanel.getOpacity() == 255) {
			if (getContentPane().getComponentCount() > 2)
				throw new UnsupportedOperationException();
			if (getContentPane().getComponentCount() > 1)
				getContentPane().remove(1);
			
			getContentPane().add(animationTarget);
			layout.putConstraint(SpringLayout.HEIGHT, animationTarget, 0,
		             SpringLayout.HEIGHT, getContentPane());
			layout.putConstraint(SpringLayout.WIDTH, animationTarget, 0,
		             SpringLayout.WIDTH, getContentPane());
			pack();
		}
			
		if (animationTarget.getParent() == getContentPane()) {
			blackPanel.setOpacity(blackPanel.getOpacity() - 32);
			if (blackPanel.getOpacity() == 0) {
				blackPanel.setVisible(false);
				animationTarget.requestFocus();
				animation.stop();
			}
			repaint();
		}
		else {
			blackPanel.setVisible(true);
			blackPanel.requestFocus();
			blackPanel.setOpacity(blackPanel.getOpacity() + 32);
			repaint();
		}
	}
	
	private static class BlackPanel extends JPanel {
		public BlackPanel() {
			super();
			setBackground(Color.BLACK);
			enableEvents(AWTEvent.MOUSE_EVENT_MASK);
		}
		
		public int getOpacity() {
			return getBackground().getAlpha();
		}
		
		public void setOpacity(int opacity) {
			if (opacity > 255)
				opacity = 255;
			if (opacity < 0)
				opacity = 0;
			setBackground(new Color(0, 0, 0, opacity));
		}
	}
}
