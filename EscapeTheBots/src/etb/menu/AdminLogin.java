package etb.menu;

import javax.swing.*;

import etb.user.Admin;

import java.awt.*;
import java.awt.event.*;
public class AdminLogin{

	private JFrame frame;
	private JFrame previousFrame;
	private Admin admin;

	public AdminLogin(JFrame previousFrame) {
		char[] password = { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' };
		admin = new Admin("admin",password);
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
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				//TODO -  add a file and store admin details using MainMenu method
				String uname=username.getText();
				char[] password = passwordField.getPassword();
				
 				loginAdmin(uname, password);
			}


		});
		btnLogin.setBackground(Color.ORANGE);
		btnLogin.setBounds(174, 180, 79, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblAdmin = new JLabel("Admin Login");
		lblAdmin.setForeground(Color.YELLOW);
		lblAdmin.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblAdmin.setBounds(159, 50, 120, 14);
		frame.getContentPane().add(lblAdmin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.ORANGE);
		btnCancel.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				cancel();
			}	
		});
		btnCancel.setBounds(263, 180, 79, 23);
		frame.getContentPane().add(btnCancel);
	}
	
	protected void loginAdmin(String uname, char[] password) {
		if(uname.equals(admin.getUsername()) && admin.isPasswordCorrect(password))
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
	
	protected void cancel() {
		frame.setVisible(false);
		previousFrame.setVisible(true);
	}
}


