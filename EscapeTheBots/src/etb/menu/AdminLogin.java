package etb.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AdminLogin extends JFrame {

	private JFrame frame;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AdminLogin() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		getContentPane().setBackground(Color.RED);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.ORANGE);
		lblUsername.setFont(new Font("Cooper Black", Font.BOLD, 13));
		lblUsername.setBounds(58, 97, 120, 23);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.ORANGE);
		lblPassword.setFont(new Font("Cooper Black", Font.BOLD, 13));
		lblPassword.setBounds(58, 131, 112, 23);
		getContentPane().add(lblPassword);
		
		JTextField username = new JTextField();
		username.setBounds(174, 98, 168, 23);
		getContentPane().add(username);
		username.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(174, 131, 168, 22);
		getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				
				String uname=username.getText();
				String pad=passwordField.getText();
				
				if(uname.equals("admin") && pad.equals("admin"))
				{
					JOptionPane.showMessageDialog(frame, "you are successfully logged in");
					frame.dispose();
					AdminMenu admin = new AdminMenu();
					admin.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Invalid username or password");
				}
			}
		});
		btnLogin.setBounds(174, 180, 79, 23);
		getContentPane().add(btnLogin);
		
		JLabel lblAdmin = new JLabel("Admin Login");
		lblAdmin.setForeground(Color.YELLOW);
		lblAdmin.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblAdmin.setBounds(159, 50, 120, 14);
		getContentPane().add(lblAdmin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
			
			}	
		});
		btnCancel.setBounds(263, 180, 79, 23);
		getContentPane().add(btnCancel);
	}
}


