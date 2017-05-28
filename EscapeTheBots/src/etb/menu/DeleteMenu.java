package etb.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

import etb.user.User;

public class DeleteMenu {
	private JTextField IntUsername;
	private JTextField ExtUsername;
	private JFrame frame;
	private JFrame previousFrame;

	public DeleteMenu(JFrame previousFrame) {
		initialize();
		frame.setVisible(true);
		this.previousFrame = previousFrame;
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.RED);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblDelete = new JLabel("Delete Window");
		lblDelete.setForeground(Color.YELLOW);
		lblDelete.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblDelete.setBounds(146, 57, 133, 14);
		frame.getContentPane().add(lblDelete);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				previousFrame.setVisible(true);

			}
		});
		btnCancel.setBounds(258, 187, 79, 23);
		frame.getContentPane().add(btnCancel);

		IntUsername = new JTextField();
		IntUsername.setBounds(240, 106, 97, 20);
		frame.getContentPane().add(IntUsername);
		IntUsername.setColumns(10);

		ExtUsername = new JTextField();
		ExtUsername.setBounds(240, 136, 97, 20);
		frame.getContentPane().add(ExtUsername);
		ExtUsername.setColumns(10);

		JLabel lblNewDuration = new JLabel("Confirm Username");
		lblNewDuration.setForeground(Color.YELLOW);
		lblNewDuration.setFont(new Font("Cooper Black", Font.BOLD, 13));
		lblNewDuration.setBounds(78, 138, 152, 14);
		frame.getContentPane().add(lblNewDuration);

		JLabel labelCurrDuration = new JLabel("Username");
		labelCurrDuration.setForeground(Color.YELLOW);
		labelCurrDuration.setFont(new Font("Cooper Black", Font.BOLD, 13));
		labelCurrDuration.setBounds(78, 108, 152, 14);
		frame.getContentPane().add(labelCurrDuration);

		JButton btnDelete = new JButton("Delete User");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String iName = IntUsername.getText();
				String eName = ExtUsername.getText();

				deleteUser(iName, eName);
			}

		});
		btnDelete.setBounds(78, 187, 113, 23);
		frame.getContentPane().add(btnDelete);
	}

	protected void deleteUser(String iName, String eName) {
		HashMap<String, User> users = MainMenu.loadFromFile();
		if (!iName.equals(eName)) {
			JOptionPane.showMessageDialog(frame, "Please enter the same username in both textboxes!");
		} else if (users.containsKey(iName)) {
			users.remove(iName);
			MainMenu.saveToFile(users);
			JOptionPane.showMessageDialog(frame, "User successfully deleted!");
			frame.setVisible(false);
			previousFrame.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(frame, "Username doesn't exist!");
		}
	}
}
