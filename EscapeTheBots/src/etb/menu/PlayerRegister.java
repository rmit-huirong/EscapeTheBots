package etb.menu;
import etb.user.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
public class PlayerRegister extends JFrame {
	
	HashMap<String, String> users = new HashMap<String, String>(); 
	
	private JFrame frame;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerRegister window = new PlayerRegister();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PlayerRegister() {
		initialize();
	}
	
	private void initialize() {
		frame =new JFrame();
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
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				
				String uname=username.getText();
				String pad=passwordField.getText();
				
				if(uname.compareTo(User.getUsername()) == 0 )
				{
					JOptionPane.showMessageDialog(frame, "User already exist");
				}
				else
				{
					users.put(uname, pad);
					JOptionPane.showMessageDialog(frame, "You are successfully registered");
					frame.dispose();
					PlayerMenu play = new PlayerMenu();
					play.setVisible(true);
				}
			}
		});
		btnRegister.setBounds(174, 180, 79, 23);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setForeground(Color.YELLOW);
		lblRegistration.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblRegistration.setBounds(159, 50, 120, 14);
		frame.getContentPane().add(lblRegistration);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
			
			}	
		});
		btnCancel.setBounds(263, 180, 79, 23);
		frame.getContentPane().add(btnCancel);
	}
}


