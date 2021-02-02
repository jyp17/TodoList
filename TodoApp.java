
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TodoApp extends JFrame implements ActionListener {
	JButton addTask;
	JButton clear;
	JTextArea taskList;
	JTextField inputTask;
	JPanel northPanel;
	
	TodoApp() {
		addTask = new JButton("Add");
		clear = new JButton("Clear All");
		taskList = new JTextArea("");
		inputTask = new JTextField(20);
		northPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		addTask.addActionListener(this);
		clear.addActionListener(this);
		
		// create layout
		setLayout(new BorderLayout());
		northPanel.add(new JLabel("Enter your task: "));
		northPanel.add(inputTask);
		northPanel.add(addTask);
		northPanel.add(clear);
		add(northPanel, BorderLayout.NORTH);
		add(taskList, BorderLayout.CENTER);
		taskList.setEditable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(650, 400);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addTask) {
			// only add task if there are non-white space characters
			if (!inputTask.getText().isBlank()) {
				taskList.append(inputTask.getText() + "\n");
			}
			
			// reset text field to blank
			inputTask.setText("");
		}
		else if (e.getSource() == clear) {			
			taskList.setText("");
		}
	}
	
	public static void main(String args[]) {
		new TodoApp();
	}

}
