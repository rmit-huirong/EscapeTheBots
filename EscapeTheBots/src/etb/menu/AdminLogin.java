package etb.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
public class AdminLogin{

	private JFrame frame;
	private JFrame previousFrame;

	public AdminLogin(JFrame previousFrame) {
		initialize();
		this.previousFrame = previousFrame;
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.RED);
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
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				//TODO -  add a file and store admin details using MainMenu method
				String uname=username.getText();
				char[] password = passwordField.getPassword();
				char[] correctPassword = { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' };
 				if(uname.equals("admin") && Arrays.equals(password, correctPassword))
				{
					JOptionPane.showMessageDialog(frame, "You are successfully logged in!");
					frame.setVisible(false);
					AdminMenu adminMenu = new AdminMenu(frame);
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Invalid username or password");
				}
			}
		});
		btnLogin.setBounds(174, 180, 79, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblAdmin = new JLabel("Admin Login");
		lblAdmin.setForeground(Color.YELLOW);
		lblAdmin.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblAdmin.setBounds(159, 50, 120, 14);
		frame.getContentPane().add(lblAdmin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				previousFrame.setVisible(true);
			}	
		});
		btnCancel.setBounds(263, 180, 79, 23);
		frame.getContentPane().add(btnCancel);
	}
}


