package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<Character> arrayText = new Stack<Character>();
	Stack<Character> deletedText = new Stack<Character>();
	String text;
	
	public static void main(String[] args) {
		_02_TextUndoRedo tur = new _02_TextUndoRedo();
		
	}
	_02_TextUndoRedo() {
		frame.add(panel);
		panel.add(label);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == frame) {
			if(e.getKeyCode() == e.VK_BACK_SPACE || e.getKeyCode() == e.VK_DELETE) {
				deletedText.add(arrayText.get(arrayText.size()-1));
				arrayText.pop();
			}else if(e.getKeyCode() == e.VK_LEFT) {
				arrayText.add(deletedText.get(deletedText.size()-1));
				deletedText.pop();
			}else {
				arrayText.add(e.getKeyChar());
			}
			text = "";
			for (int i = 0; i < arrayText.size(); i++) {
				text+=arrayText.get(i);
			}
			label.setText("");
			label.setText(text);
			panel.repaint();
			frame.repaint();
			label.repaint();
			frame.pack();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
