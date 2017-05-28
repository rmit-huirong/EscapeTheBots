package etb.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

import etb.user.User;

public class ScoreMenu {
	private JTextField winScore;
	private JTextField loseScore;
	private JFrame frame;
	private JFrame previousFrame;
	private User user;

	public ScoreMenu(JFrame previousFrame, User user) {
		this.user = user;
		initialize();
		frame.setVisible(true);
		this.previousFrame = previousFrame;
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.RED);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblDelete = new JLabel("Score Menu");
		lblDelete.setForeground(Color.YELLOW);
		lblDelete.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblDelete.setBounds(146, 57, 133, 14);
		frame.getContentPane().add(lblDelete);

		JButton btnCancel = new JButton("Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				previousFrame.setVisible(true);

			}
		});
		btnCancel.setBounds(258, 187, 79, 23);
		frame.getContentPane().add(btnCancel);

		winScore = new JTextField();
		winScore.setBounds(240, 106, 97, 20);
		winScore.setText(this.user.getWinScore());
		winScore.setEditable(false);
		frame.getContentPane().add(winScore);
		winScore.setColumns(10);

		loseScore = new JTextField();
		loseScore.setBounds(240, 136, 97, 20);
		loseScore.setText(this.user.getLoseScore());
		loseScore.setEditable(false);
		frame.getContentPane().add(loseScore);
		loseScore.setColumns(10);

		JLabel lblLoseScore = new JLabel("Lose Score");
		lblLoseScore.setForeground(Color.YELLOW);
		lblLoseScore.setFont(new Font("Cooper Black", Font.BOLD, 13));
		lblLoseScore.setBounds(78, 138, 152, 14);
		frame.getContentPane().add(lblLoseScore);

		JLabel lblWinScore = new JLabel("Win Score");
		lblWinScore.setForeground(Color.YELLOW);
		lblWinScore.setFont(new Font("Cooper Black", Font.BOLD, 13));
		lblWinScore.setBounds(78, 108, 152, 14);
		frame.getContentPane().add(lblWinScore);

		JButton btnDelete = new JButton("Reset Scores");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetScores();
			}

		});
		btnDelete.setBounds(78, 187, 113, 23);
		frame.getContentPane().add(btnDelete);
	}

	protected void resetScores() {
		HashMap<String,User> users = MainMenu.loadFromFile();
		user = users.get(user.getUsername());
		user.resetScores();
		users.replace(user.getUsername(), user);
		MainMenu.saveToFile(users);
		System.out.println(user.getLoseScore());
		loseScore.setText(user.getLoseScore());
		winScore.setText(user.getWinScore());
	}

}
