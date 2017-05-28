package etb.menu;

import javax.imageio.ImageIO;
import javax.swing.*;

import etb.game.Game;
import etb.user.User;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;


public class GamerMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JFrame previousFrame;
	private User user;
	
	public GamerMenu(JFrame previousFrame, User user){
		this.user = user;
		initialize();
		this.previousFrame = previousFrame;
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame =new JFrame();
		frame.getContentPane().setBackground(new Color(27,91,127));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		try{
		BufferedImage image = ImageIO.read(new File("logo.png"));
		Icon icon = new ImageIcon(image);
		JLabel lblIcon = new JLabel(icon);
		lblIcon.setBounds(110, 20, icon.getIconWidth(), icon.getIconHeight());
		lblIcon.setBorder(null);
		frame.getContentPane().add(lblIcon);
		
		JButton btnPlay = new JButton("Play Game");
		btnPlay.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnPlay.setBackground(Color.ORANGE);
		btnPlay.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				playGame(user);
			}	
		});
		btnPlay.setBounds(143, 125, 139, 23);
		frame.getContentPane().add(btnPlay);
		
		JButton btnHighScore = new JButton("Scores");
		btnHighScore.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnHighScore.setBackground(Color.ORANGE);
		btnHighScore.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				openScoreMenu();
			
			}	
		});
		btnHighScore.setBounds(143, 155, 139, 23);
		frame.getContentPane().add(btnHighScore);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnLogOut.setBackground(Color.ORANGE);
		btnLogOut.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				logout();
				
			}

			
		});
		btnLogOut.setBounds(143, 200, 139, 23);
		frame.getContentPane().add(btnLogOut);
		}catch(Exception e){
			
		}
	}
	
	protected void logout() {
		frame.setVisible(false);
		previousFrame.setVisible(true);
	}

	protected void playGame(User user) {
		frame.setVisible(false);
		Game game = new Game(frame, user);

		
	}

	protected void openScoreMenu() {
		HashMap<String,User> users = MainMenu.loadFromFile();
		user = users.get(user.getUsername());
		frame.setVisible(false);
		ScoreMenu scoreMenu = new ScoreMenu(frame,user);
	}	
	
}
	



