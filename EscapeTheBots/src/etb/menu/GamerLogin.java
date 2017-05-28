	/*
	 * Author - Muhammad Syafiq- s3596883
	 */

package etb.menu;

import etb.user.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class GamerLogin {

	private JFrame frame;
	private JFrame previousFrame;
	private HashMap<String, User> users;

	public GamerLogin(JFrame previousFrame) {
		initialize();
		this.previousFrame = previousFrame;
		frame.setVisible(true);
		users = MainMenu.loadFromFile();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(27,91,127));
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
		btnLogin.setBackground(Color.ORANGE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uname = username.getText();
				char[] password = passwordField.getPassword();
				users = MainMenu.loadFromFile();

				login(uname, password);
			}

		});
		btnLogin.setBounds(174, 180, 79, 23);
		frame.getContentPane().add(btnLogin);

		JLabel lblGamer = new JLabel("Gamer Login");
		lblGamer.setForeground(Color.YELLOW);
		lblGamer.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblGamer.setBounds(159, 50, 120, 14);
		frame.getContentPane().add(lblGamer);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.ORANGE);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancel();

			}

		});
		btnCancel.setBounds(263, 180, 79, 23);
		frame.getContentPane().add(btnCancel);

		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(Color.ORANGE);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openRegisterWindow();

			}

		});
		btnRegister.setBounds(65, 180, 100, 23);
		frame.getContentPane().add(btnRegister);
	}

	protected void login(String uname, char[] password) {
		if (users != null) {
			if (users.containsKey(uname)) {
				User user = users.get(uname);
				if (user.isPasswordCorrect(password)) {
					JOptionPane.showMessageDialog(frame, "You are successfully logged in!");
					frame.setVisible(false);
					GamerMenu gamerMenu = new GamerMenu(frame,user);
				} else {
					JOptionPane.showMessageDialog(frame, "Invalid username or password");
				}
			} else {
				JOptionPane.showMessageDialog(frame, "Invalid username or password");
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Invalid username or password");
		}
	}

	protected void openRegisterWindow() {
		frame.setVisible(false);
		GamerRegister gamerRegister = new GamerRegister(frame);
	}

	protected void cancel() {
		frame.setVisible(false);
		previousFrame.setVisible(true);
	}
}
