package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HangMan implements KeyListener {
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	Stack<String> words = new Stack<String>();
	String currentWord;
	String wordDisplay = "";
	Character[] wordDisplayArray;
	int livesRemaining =10;
	public static void main(String[] args) {
		HangMan hangman = new HangMan();
		Utilities utilities = new Utilities();
		String word;
		String amountInput = JOptionPane.showInputDialog("Welcome to HANGMAN! \n How many words would you "
		+ "like to guess? (1 to 266)");
		int amount = Integer.parseInt(amountInput);
		for (int i = 0; i < amount; i++) {
			word = utilities.readRandomLineFromFile("dictionary.txt");
			if(!hangman.words.contains(word)) {
				hangman.words.add(word);
			}else {
				i--;
			}
		}
		hangman.run();
	}
	void run() {
		currentWord = words.get(words.size()-1);
		for (int i = 0; i < currentWord.length(); i++) {
			wordDisplay+="_";
		}
		label.setText(wordDisplay + " Lives Remaining: " + livesRemaining);
		System.out.println(currentWord);
		words.pop();
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(3);
		frame.add(label);
		frame.pack();
		frame.setVisible(true);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == frame) {
			char keyPressed = e.getKeyChar();
			if(currentWord.indexOf(keyPressed) != -1) {
				wordDisplay.toCharArray();
				wordDisplayArray = new Character[wordDisplay.length()];
				for (int i = 0; i < wordDisplayArray.length; i++) {
					if(currentWord.charAt(i) == keyPressed) {
						wordDisplayArray[i] = keyPressed;
					}else {
						wordDisplayArray[i] = wordDisplay.charAt(i);
					}
				}
				wordDisplay = "";
				for (int i = 0; i < wordDisplayArray.length; i++) {
					wordDisplay+=wordDisplayArray[i];
				}
			}else {
				livesRemaining--;
				if(livesRemaining<=0) {
					JOptionPane.showMessageDialog(null, "You ran out of lives. The word was " + currentWord);
					System.exit(0);
				}
			}
			label.setText(wordDisplay + " Lives Remaining: " + livesRemaining);
			System.out.println(wordDisplay + " Lives Remaining: " + livesRemaining);
			frame.pack();
			frame.repaint();
			if(wordDisplay.equals(currentWord)) {
				if(!words.empty()) {
					livesRemaining = 10;
					currentWord = words.get(words.size()-1);
					wordDisplay = "";
					for (int i = 0; i < currentWord.length(); i++) {
						wordDisplay+="_";
					}
					label.setText(wordDisplay + " Lives Remaining: " + livesRemaining);
					frame.pack();
					frame.repaint();
					System.out.println(currentWord);
					words.pop();
				}else {
					JOptionPane.showMessageDialog(null, "Congratulations! You beat the game!");
					System.exit(0);
				}
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
