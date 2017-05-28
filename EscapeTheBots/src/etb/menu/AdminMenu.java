	/*
	 * Author - Navod Bopitiya - s3617221
	 */

package etb.menu;

import javax.imageio.ImageIO;
import javax.swing.*;

import etb.game.Game;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;


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
		try{
		frame =new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(27,91,127));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		BufferedImage image = ImageIO.read(new File("logo.png"));
		Icon icon = new ImageIcon(image);
		JLabel lblIcon = new JLabel(icon);
		lblIcon.setBounds(110, 20, icon.getIconWidth(), icon.getIconHeight());
		lblIcon.setBorder(null);
		frame.getContentPane().add(lblIcon);
		
		JButton btnChangeDuration = new JButton("Change Duration");
		btnChangeDuration.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnChangeDuration.setBackground(Color.ORANGE);
		btnChangeDuration.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				openDurationMenu();
			}	
		});
		btnChangeDuration.setBounds(134, 125, 159, 23);
		frame.getContentPane().add(btnChangeDuration);
		
		JButton btnDeleteGamer = new JButton("Delete Gamer");
		btnDeleteGamer.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnDeleteGamer.setBackground(Color.ORANGE);
		btnDeleteGamer.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				openDeleteMenu();
			}	
		});
		btnDeleteGamer.setBounds(134, 155, 159, 23);
		frame.getContentPane().add(btnDeleteGamer);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnLogOut.setBackground(Color.ORANGE);
		btnLogOut.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				logOut();
			}	
		});
		btnLogOut.setBounds(134, 200, 159, 23);
		frame.getContentPane().add(btnLogOut);
		}catch(Exception e){
			
		}
		
	}

	protected void openDurationMenu() {
		DurationMenu durationMenu = new DurationMenu(frame);
	}

	protected void openDeleteMenu() {
		DeleteMenu deleteMenu = new DeleteMenu(frame);
	}
	
	protected void logOut() {
		frame.setVisible(false);
		previousFrame.setVisible(true);
	}
}
	



