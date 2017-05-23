package etb.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PlayerMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerMenu window = new PlayerMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PlayerMenu(){
		initialize();
	}
	
	private void initialize() {
		frame =new JFrame();
		frame.getContentPane().setBackground(Color.RED);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		JLabel lblMenu = new JLabel("Player Menu");
		lblMenu.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblMenu.setForeground(Color.YELLOW);
		lblMenu.setBounds(157, 38, 114, 39);
		frame.getContentPane().add(lblMenu);
		
		JButton btnPlayer = new JButton("Play Game");
		btnPlayer.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnPlayer.setBackground(Color.ORANGE);
		btnPlayer.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Login exFrame = new Login();
				exFrame.setVisible(true);
			}	
		});
		btnPlayer.setBounds(143, 98, 139, 23);
		frame.getContentPane().add(btnPlayer);
		
		JButton btnAdmin = new JButton("High Score");
		btnAdmin.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnAdmin.setBackground(Color.ORANGE);
		btnAdmin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
			
			}	
		});
		btnAdmin.setBounds(143, 132, 139, 23);
		frame.getContentPane().add(btnAdmin);
		
		JButton btnCredit = new JButton("Credit");
		btnCredit.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnCredit.setBackground(Color.ORANGE);
		btnCredit.setBounds(143, 166, 139, 23);
		frame.getContentPane().add(btnCredit);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnLogOut.setBackground(Color.ORANGE);
		btnLogOut.setBounds(143, 200, 139, 23);
		frame.getContentPane().add(btnLogOut);
		
	}
	
}
	



