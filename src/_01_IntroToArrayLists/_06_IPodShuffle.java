package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	JButton button = new JButton("Suprise Me!");
	ArrayList<Song> songs = new ArrayList<Song>();
	JFrame frame = new JFrame();
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		button.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(button);
		frame.pack();
		frame.setVisible(true);
		songs.add(new Song("demo.mp3"));
		songs.add(new Song("Hypnotic-Puzzle.mp3"));
		songs.add(new Song("Pixel-Drama.mp3"));
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button) {
			for (int i = 0; i < songs.size(); i++) {
				songs.get(i).stop();
			}
			songs.get(new Random().nextInt(songs.size())).play();
		}
	}
}