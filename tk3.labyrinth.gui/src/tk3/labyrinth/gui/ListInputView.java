package tk3.labyrinth.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.border.CompoundBorder;

@SuppressWarnings("serial")
public abstract class ListInputView extends JPanel {
	private JLabel textDesc;
	private JTextField textField;
	private JButton button;
	private JList<String> list;
	
	public ListInputView() {
		super(new BorderLayout());
		
		CompoundBorder textBorder = BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLUE, 1),
				BorderFactory.createEmptyBorder(2, 2, 2, 2));
		
		textDesc = new JLabel();
		textDesc.setForeground(Color.WHITE);
		
		textField = new JTextField();
		textField.setBorder(textBorder);
		textField.setBackground(new Color(128, 128, 255));
		textField.setForeground(Color.WHITE);
		
		JPanel textFieldPanel = new JPanel(new BorderLayout());
		textFieldPanel.setOpaque(false);
		textFieldPanel.add(textField);
		textFieldPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		
		button = new JButton();
		button.setBorder(textBorder);
		button.setBackground(new Color(128, 128, 255));
		button.setForeground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				buttonClicked();
			}
		});
		button.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent event) { }
			public void keyReleased(KeyEvent event) { }
			public void keyPressed(KeyEvent event) {
				if (event.getKeyCode() == KeyEvent.VK_ENTER)
					buttonClicked();
			}
		});
		
		list = new JList<>();
		list.setOpaque(false);
		list.setCellRenderer(new CellRenderer());
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (list.isEnabled() && event.getClickCount() == 2) {
					int index = list.locationToIndex(event.getPoint());
					if (index != -1)
						listItemClicked(list.getModel().getElementAt(index));
				}
			}
		});
		list.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent event) { }
			public void keyReleased(KeyEvent event) { }
			public void keyPressed(KeyEvent event) {
				if (event.getKeyCode() == KeyEvent.VK_ENTER) {
					int index = list.getSelectedIndex();
					if (index != -1)
						listItemClicked(list.getModel().getElementAt(index));
				}
			}
		});
		
		JPanel listPanel = new JPanel(new BorderLayout());
		listPanel.setBackground(new Color(32, 32, 64));
		listPanel.add(list);
		listPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(new Color(64, 64, 128));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.add(textFieldPanel);
		panel.add(textDesc, BorderLayout.BEFORE_LINE_BEGINS);
		panel.add(button, BorderLayout.AFTER_LINE_ENDS);
		
		add(listPanel);
		add(panel, BorderLayout.BEFORE_FIRST_LINE);
	}
	
	public void setList(List<String> items, boolean enabled) {
		String[] data = new String[items.size()];
		items.toArray(data);
		list.setListData(data);
		list.setEnabled(enabled);
	}
	
	public void setButtonText(String text) {
		button.setText(text);
	}
	
	public void setInputDesc(String text) {
		textDesc.setText(text);
	}
	
	public void setInputText(String text) {
		textField.setText(text);
	}
	
	public String getInputText() {
		return textField.getText();
	}
	
	protected abstract void buttonClicked();
	
	protected abstract void listItemClicked(String item);
	
	private static class CellRenderer extends JLabel implements ListCellRenderer<String> {
		public CellRenderer() {
			super();
			setHorizontalAlignment(CENTER);
			setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 10));
		}
		
	    @Override
	    public void validate() { }
	    
	    @Override
	    public void invalidate() { }
	    
	    @Override
	    public void repaint() { }
	    
	    @Override
	    public void revalidate() { }
	    
	    @Override
	    public void repaint(long tm, int x, int y, int width, int height) { }
	    
	    @Override
	    public void repaint(Rectangle r) { }
	    
		@Override
		public Component getListCellRendererComponent(
				JList<? extends String> list, String value, int index,
				boolean isSelected, boolean cellHasFocus) {
			setForeground(cellHasFocus ? Color.YELLOW : Color.WHITE);
			setText(value);
			return this;
		}
	}
}
