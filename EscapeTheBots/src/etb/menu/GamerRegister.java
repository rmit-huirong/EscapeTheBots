	/*
	 * Author - Navod Bopitiya - s3617221
	 */

	/*
	 * Author - Muhammad Syafiq- s3596883
	 */

package etb.menu;

import etb.user.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class GamerRegister{

	private HashMap<String, User> users;


	private JFrame frame;
	private JFrame previousFrame;

	public GamerRegister(JFrame previousFrame) {
		initialize();
		this.previousFrame = previousFrame;
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(27,91,127));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.ORANGE);
		lblUsername.setFont(new Font("Cooper Black", Font.BOLD, 13));
		lblUsername.setBounds(58, 97, 120, 23);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.ORANGE);
		lblPassword.setFont(new Font("Cooper Black", Font.BOLD, 13));
		lblPassword.setBounds(58, 131, 112, 23);
		frame.getContentPane().add(lblPassword);

		JTextField username = new JTextField();
		username.setBounds(174, 98, 168, 23);
		frame.getContentPane().add(username);
		username.setColumns(10);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(174, 131, 168, 22);
		frame.getContentPane().add(passwordField);

		HashMap<String, User> loadedUsers = MainMenu.loadFromFile();

		if (loadedUsers != null) {
			users = loadedUsers;
		}else{
			users = new HashMap<String,User>();
		}

		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(Color.ORANGE);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String uname = username.getText();
				char[] password = passwordField.getPassword();	
				register(uname, password);
			}


		});
		btnRegister.setBounds(160, 180, 90, 23);
		frame.getContentPane().add(btnRegister);

		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setForeground(Color.YELLOW);
		lblRegistration.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblRegistration.setBounds(159, 50, 120, 14);
		frame.getContentPane().add(lblRegistration);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.ORANGE);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				previousFrame.setVisible(true);
			}
		});
		btnCancel.setBounds(263, 180, 79, 23);
		frame.getContentPane().add(btnCancel);
	}
	
	public boolean validatePassword(char[] password){ // TODO - better validation!
		if(password == null){
			return false;
		}else if(password.length < 3){
			return false;
		}else{
			return true;
		}
	}
	
	protected void register(String uname, char[] password) {
		if (!users.containsKey(uname)) {			
			if(validatePassword(password)){
			User user = new User(uname,password);
			users.put(uname, user);
			MainMenu.saveToFile(users);
			JOptionPane.showMessageDialog(frame, "You are successfully registered");
			frame.setVisible(false);
			GamerMenu gamerMenu = new GamerMenu(previousFrame,user);
			}else{
				JOptionPane.showMessageDialog(frame, "Enter a stronger password!");
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Username already exists, please try again!");
		}
	}

}
