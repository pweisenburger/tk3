package tk3.labyrinth.gui;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements ActionListener, GameManagerObserver {
	private GameManager gameManager;
	private SpringLayout layout;
	private BlackPanel blackPanel;
	private Timer animation;
	private ListInputView gameList;
	private JComponent animationTarget;
	
	public GameFrame(GameManager manager) {
		gameManager = manager;
		
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
				System.out.println("item clicked");
			}
			
			protected void buttonClicked() {
				gameManager.startNewGame(Main.testGame());
			}
		};
		gameList.setInputDesc("Player name: ");
		gameList.setInputText(System.getProperty("user.name"));
		gameList.setButtonText("New Game");
		
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
	public void joinGame(String gameId) {
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
