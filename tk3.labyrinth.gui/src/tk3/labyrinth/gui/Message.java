package tk3.labyrinth.gui;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public abstract class Message extends JPanel {
	private JLabel label;
	
	public Message() {
		super();
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setBackground(new Color(32, 32, 64));
		
		label = new JLabel("test");
		label.setForeground(Color.WHITE);
		label.setBackground(new Color(64, 64, 128));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		label.setOpaque(true);
		
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, label, 0,
	                         SpringLayout.VERTICAL_CENTER, this);
		layout.putConstraint(SpringLayout.WIDTH, label, 0,
			                 SpringLayout.WIDTH, this);

		add(label);
	}
	
	@Override
	protected void processKeyEvent(KeyEvent event) {
		clicked();
	}
	
	public void setText(String text) {
		label.setText(text);
	}
	
	protected abstract void clicked();
}