package etb.menu;

import javax.imageio.ImageIO;
import javax.swing.*;

import etb.user.User;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private HashMap<String, User> users = new HashMap<String, User>();
	public GamerLogin gamer;
	public AdminLogin admin;

	public HashMap<String, User> getUsers() {
		return users;
	}

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

	public MainMenu() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(27,91,127));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		try {
			BufferedImage image = ImageIO.read(new File("logo.png"));
			Icon icon = new ImageIcon(image);
			JLabel lblIcon = new JLabel(icon);
			lblIcon.setBounds(103, 20, icon.getIconWidth(), icon.getIconHeight());
			lblIcon.setBorder(null);
			frame.getContentPane().add(lblIcon);

			JButton btnGamer = new JButton("Gamer");
			btnGamer.setFont(new Font("Cooper Black", Font.PLAIN, 13));
			btnGamer.setBackground(Color.ORANGE);
			btnGamer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					openGamerLoginWindow();
				}

			});
			btnGamer.setBounds(132, 135, 139, 23);
			frame.getContentPane().add(btnGamer);

			JButton btnAdmin = new JButton("Admin");
			btnAdmin.setFont(new Font("Cooper Black", Font.PLAIN, 13));
			btnAdmin.setBackground(Color.ORANGE);
			btnAdmin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					openAdminLoginWindow();
				}
			});
			btnAdmin.setBounds(132, 170, 139, 23);
			frame.getContentPane().add(btnAdmin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void saveToFile(HashMap<String, User> users) {
		// write to file : "users"
		try {
			File fileOne = new File("users");
			FileOutputStream fos = new FileOutputStream(fileOne);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(users);
			oos.flush();
			oos.close();
			fos.close();

		} catch (Exception e) {

		}

	}

	public static HashMap<String, User> loadFromFile() {
		// read from file
		HashMap<String, User> mapInFile = null;
		try {
			File toRead = new File("users");
			FileInputStream fis = new FileInputStream(toRead);
			ObjectInputStream ois = new ObjectInputStream(fis);

			mapInFile = (HashMap<String, User>) ois.readObject();
			ois.close();
			fis.close();

		} catch (Exception e) {

		}
		return mapInFile;
	}

	protected void openGamerLoginWindow() {
		frame.setVisible(false);
		gamer = new GamerLogin(frame);
	}

	protected void openAdminLoginWindow() {
		frame.setVisible(false);
		admin = new AdminLogin(frame);
	}

}
