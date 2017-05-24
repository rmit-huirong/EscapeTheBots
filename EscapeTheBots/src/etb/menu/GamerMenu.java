package etb.menu;

import javax.swing.*;

import etb.game.Game;

import java.awt.*;
import java.awt.event.*;


public class GamerMenu extends JFrame {

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
					GamerMenu window = new GamerMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GamerMenu(){
		initialize();
	}
	
	private void initialize() {
		frame =new JFrame();
		frame.getContentPane().setBackground(Color.RED);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		JLabel lblMenu = new JLabel("Gamer Menu");
		lblMenu.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblMenu.setForeground(Color.YELLOW);
		lblMenu.setBounds(157, 38, 114, 39);
		frame.getContentPane().add(lblMenu);
		
		JButton btnPlay = new JButton("Play Game");
		btnPlay.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnPlay.setBackground(Color.ORANGE);
		btnPlay.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Game exFrame = new Game();
				exFrame.setVisible(true);
			}	
		});
		btnPlay.setBounds(143, 98, 139, 23);
		frame.getContentPane().add(btnPlay);
		
		JButton btnHighScore = new JButton("High Score");
		btnHighScore.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnHighScore.setBackground(Color.ORANGE);
		btnHighScore.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
			
			}	
		});
		btnHighScore.setBounds(143, 132, 139, 23);
		frame.getContentPane().add(btnHighScore);
		
		JButton btnCredit = new JButton("Credit");
		btnCredit.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnCredit.setBackground(Color.ORANGE);
		btnCredit.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
			
			}	
		});
		btnCredit.setBounds(143, 166, 139, 23);
		frame.getContentPane().add(btnCredit);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnLogOut.setBackground(Color.ORANGE);
		btnLogOut.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
			
			}	
		});
		btnLogOut.setBounds(143, 200, 139, 23);
		frame.getContentPane().add(btnLogOut);
		
	}
	
}
	



