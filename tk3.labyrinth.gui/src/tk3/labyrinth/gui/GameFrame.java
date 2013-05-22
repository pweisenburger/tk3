package tk3.labyrinth.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

import tk3.labyrinth.Game;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	public GameFrame(Game game) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(640, 480));
		setMinimumSize(new Dimension(400, 400));
		setFocusable(true);
		setVisible(true);
		setLocationRelativeTo(null);
		
		GameField gameField = new GameField(game);
		getContentPane().add(gameField);
		//getContentPane().add(new GameList());
		gameField.requestFocus();
		pack();
	}
}
