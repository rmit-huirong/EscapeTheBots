package etb.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainMenu {

	private JFrame frame;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainMenu(){
		initialize();
	}
	
	private void initialize() {
		frame =new JFrame();
		frame.getContentPane().setBackground(Color.RED);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		JLabel lblMenu = new JLabel("Welcome to Escape the Bots");
		lblMenu.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblMenu.setForeground(Color.YELLOW);
		lblMenu.setBounds(77, 57, 268, 39);
		frame.getContentPane().add(lblMenu);
		
		JButton btnGamer = new JButton("Gamer");
		btnGamer.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnGamer.setBackground(Color.ORANGE);
		btnGamer.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				GamerLogin exFrame = new GamerLogin();
				exFrame.setVisible(true);
			}	
		});
		btnGamer.setBounds(132, 119, 139, 23);
		frame.getContentPane().add(btnGamer);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnAdmin.setBackground(Color.ORANGE);
		btnAdmin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				AdminLogin admin = new AdminLogin();
				admin.setVisible(true);
			}	
		});
		btnAdmin.setBounds(132, 153, 139, 23);
		frame.getContentPane().add(btnAdmin);
		
	}
	
}
	



