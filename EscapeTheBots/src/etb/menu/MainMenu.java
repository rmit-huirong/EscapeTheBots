package etb.menu;

import javax.swing.*;

import etb.user.User;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
				loginGamer();
			}


		});
		btnGamer.setBounds(132, 119, 139, 23);
		frame.getContentPane().add(btnGamer);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnAdmin.setBackground(Color.ORANGE);
		btnAdmin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				loginAdmin();
			}	
		});
		btnAdmin.setBounds(132, 153, 139, 23);
		frame.getContentPane().add(btnAdmin);
		
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
	
	protected void loginGamer() {
		frame.setVisible(false);
		gamer = new GamerLogin(frame);
	}

	protected void loginAdmin() {
		frame.setVisible(false);
		admin = new AdminLogin(frame);
	}	
	
}
	



