package etb.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PlayerLogin extends JFrame {

	private JFrame frame;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerLogin window = new PlayerLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PlayerLogin() {
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
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				
				String uname=username.getText();
				String pad=passwordField.getText();
				
				if(uname.equals("name") && pad.equals("password"))
				{
					JOptionPane.showMessageDialog(frame, "you are successfully logged in");
					frame.dispose();
					PlayerMenu exFrame = new PlayerMenu();
					exFrame.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Invalid username or password");
				}
			}
		});
		btnLogin.setBounds(174, 180, 79, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblPlayer = new JLabel("Player Login");
		lblPlayer.setForeground(Color.YELLOW);
		lblPlayer.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblPlayer.setBounds(159, 50, 120, 14);
		frame.getContentPane().add(lblPlayer);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
			
			}	
		});
		btnCancel.setBounds(263, 180, 79, 23);
		frame.getContentPane().add(btnCancel);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(Color.WHITE);
		btnRegister.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
			
			}	
		});
		btnRegister.setBounds(58, 180, 73, 23);
		frame.getContentPane().add(btnRegister);
	}
}


