package tk3.labyrinth.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GameList extends JPanel {
	public GameList() {
		super(new BorderLayout());
		
		JLabel label = new JLabel("Player name: ");
		JTextField textField = new JTextField("Player");
		JButton button = new JButton("New Game");
		JList<String> list = new JList<>(new String[] { "Game #1", "Game #2" });
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(textField);
		panel.add(label, BorderLayout.BEFORE_LINE_BEGINS);
		panel.add(button, BorderLayout.AFTER_LINE_ENDS);
		
		add(list);
		add(panel, BorderLayout.BEFORE_FIRST_LINE);
	}
}
