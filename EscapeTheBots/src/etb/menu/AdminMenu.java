package etb.menu;

import javax.swing.*;

import etb.game.Game;

import java.awt.*;
import java.awt.event.*;


public class AdminMenu extends JFrame {

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
					AdminMenu window = new AdminMenu();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AdminMenu(){
		initialize();
	}
	
	private void initialize() {
		frame =new JFrame();
		getContentPane().setBackground(Color.RED);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
				
		JLabel lblMenu = new JLabel("Admin Menu");
		lblMenu.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblMenu.setForeground(Color.YELLOW);
		lblMenu.setBounds(156, 47, 114, 39);
		getContentPane().add(lblMenu);
		
		JButton btnChangeDuration = new JButton("Change Duration");
		btnChangeDuration.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnChangeDuration.setBackground(Color.ORANGE);
		btnChangeDuration.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				DurationMenu window = new DurationMenu();
				window.setVisible(true);
				varyDuration(50);
			}	
		});
		btnChangeDuration.setBounds(134, 109, 159, 23);
		getContentPane().add(btnChangeDuration);
		
		JButton btnDeleteGamer = new JButton("Delete Gamer");
		btnDeleteGamer.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnDeleteGamer.setBackground(Color.ORANGE);
		btnDeleteGamer.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				DeleteMenu window = new DeleteMenu();
				window.setVisible(true);
				varyDuration(50);
			}	
		});
		btnDeleteGamer.setBounds(134, 143, 159, 23);
		getContentPane().add(btnDeleteGamer);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnLogOut.setBackground(Color.ORANGE);
		btnLogOut.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				
			}	
		});
		btnLogOut.setBounds(134, 177, 159, 23);
		getContentPane().add(btnLogOut);
		
	}
	
	public void varyDuration(int value){
		//TODO -change countdown according to entered value - Must be validated first (x>0 and x<1000)?
		Game.setCountDown(value);
	}
	
}
	



