package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addEntry = new JButton("Add Entry");
	JButton searchByID = new JButton("Search by ID");
	JButton viewList = new JButton("View List");
	JButton removeEntry = new JButton("Remove Entry");
	HashMap<Integer, String> students = new HashMap<Integer, String>();
	Object[] studentIDs = students.keySet().toArray();
	Object[] studentNames = students.values().toArray();
	_02_LogSearch(){
		frame.add(panel);
		panel.add(addEntry);
		panel.add(searchByID);
		panel.add(viewList);
		panel.add(removeEntry);
		addEntry.addActionListener(this);
		searchByID.addActionListener(this);
		viewList.addActionListener(this);
		removeEntry.addActionListener(this);
		frame.pack();
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		_02_LogSearch ls = new _02_LogSearch();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addEntry) {
			students.put(Integer.parseInt(JOptionPane.showInputDialog("Please enter an ID number.")), 
					JOptionPane.showInputDialog("Please enter a student name"));
			studentIDs = students.keySet().toArray();
			studentNames = students.values().toArray();
		}
		if(e.getSource() == searchByID) {
			String iD = JOptionPane.showInputDialog("Please enter an ID number");
			int id = Integer.parseInt(iD);
			if(getIndex(studentIDs, id) != -1) {
				JOptionPane.showMessageDialog(null, "The student is " + studentNames[getIndex(studentIDs, id)]);
			}else {
				JOptionPane.showMessageDialog(null, "Sorry, that entry does not exist");
			}
		}
		if(e.getSource() == viewList) {
			String list = "";
			for (int i = 0; i < studentNames.length; i++) {
				list += "ID: " + studentIDs[i] + "   Name: " + studentNames[i] + "\n";
			}
			JOptionPane.showMessageDialog(null, list);
		}
		if(e.getSource() == removeEntry) {
			String remove = JOptionPane.showInputDialog("Please enter an ID number");
			if(getIndex(studentIDs, Integer.parseInt(remove)) != -1) {
				JOptionPane.showMessageDialog(null, studentNames[getIndex(studentIDs, Integer.parseInt(remove))]  + " is re"
						+ "moved");
				students.remove(Integer.parseInt(remove));
				studentIDs = students.keySet().toArray();
				studentNames = students.values().toArray();
			}else {
				JOptionPane.showMessageDialog(null, "Sorry, that entry does not exist");
			}
		}
	}
	int getIndex(Object[] array, Object obj) {
		for (int i = 0; i < array.length; i++) {
			if(array[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}
}