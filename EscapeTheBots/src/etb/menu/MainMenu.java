package etb.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;


public class MainMenu extends JFrame {

	private JFrame frame;
	private HashMap<String, char[]> users = new HashMap<String, char[]>();
	public GamerLogin gamer;
	public AdminLogin admin;
	
	public HashMap<String, char[]> getUsers() {
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
				frame.setVisible(false);
				gamer = new GamerLogin(frame);
			}	
		});
		btnGamer.setBounds(132, 119, 139, 23);
		frame.getContentPane().add(btnGamer);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnAdmin.setBackground(Color.ORANGE);
		btnAdmin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				admin = new AdminLogin(frame);
			}	
		});
		btnAdmin.setBounds(132, 153, 139, 23);
		frame.getContentPane().add(btnAdmin);
		
	}
	
	public static void saveToFile(HashMap<String, char[]> users) {
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

	public static HashMap<String, char[]> loadFromFile() {
		// read from file
		HashMap<String, char[]> mapInFile = null;
		try {
			File toRead = new File("users");
			FileInputStream fis = new FileInputStream(toRead);
			ObjectInputStream ois = new ObjectInputStream(fis);

			mapInFile = (HashMap<String, char[]>) ois.readObject();
			ois.close();
			fis.close();

		} catch (Exception e) {
		}
		return mapInFile;
	}
	
}
	



