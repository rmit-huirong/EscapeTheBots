package etb.menu;

import javax.swing.*;

import etb.game.Game;

import java.awt.*;
import java.awt.event.*;


public class AdminMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JFrame previousFrame;
	public AdminMenu(JFrame previousFrame){
		initialize();
		this.previousFrame = previousFrame;
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame =new JFrame();
		frame.getContentPane().setBackground(Color.RED);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		JLabel lblMenu = new JLabel("Admin Menu");
		lblMenu.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblMenu.setForeground(Color.YELLOW);
		lblMenu.setBounds(156, 47, 114, 39);
		frame.getContentPane().add(lblMenu);
		
		JButton btnChangeDuration = new JButton("Change Duration");
		btnChangeDuration.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnChangeDuration.setBackground(Color.ORANGE);
		btnChangeDuration.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				DurationMenu durationMenu = new DurationMenu(frame);
			}	
		});
		btnChangeDuration.setBounds(134, 109, 159, 23);
		frame.getContentPane().add(btnChangeDuration);
		
		JButton btnDeleteGamer = new JButton("Delete Gamer");
		btnDeleteGamer.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnDeleteGamer.setBackground(Color.ORANGE);
		btnDeleteGamer.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				DeleteMenu deleteMenu = new DeleteMenu(frame);
			}	
		});
		btnDeleteGamer.setBounds(134, 143, 159, 23);
		frame.getContentPane().add(btnDeleteGamer);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnLogOut.setBackground(Color.ORANGE);
		btnLogOut.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				previousFrame.setVisible(true);
			}	
		});
		btnLogOut.setBounds(134, 177, 159, 23);
		frame.getContentPane().add(btnLogOut);
		
	}
	
	
}
	



