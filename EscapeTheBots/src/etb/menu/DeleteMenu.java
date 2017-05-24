package etb.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DeleteMenu extends JFrame {
	private JTextField IntUsername;
	private JTextField ExtUsername;
	private JFrame frame;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteMenu window = new DeleteMenu();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DeleteMenu() {
		initialize();
	}
	
	private void initialize() {
		frame =new JFrame();
		getContentPane().setBackground(Color.RED);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblDelete = new JLabel("Delete Window");
		lblDelete.setForeground(Color.YELLOW);
		lblDelete.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblDelete.setBounds(146, 57, 133, 14);
		getContentPane().add(lblDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(258, 187, 79, 23);
		getContentPane().add(btnCancel);
		
		IntUsername = new JTextField();
		IntUsername.setBounds(240, 106, 97, 20);
		getContentPane().add(IntUsername);
		IntUsername.setColumns(10);
		
		ExtUsername = new JTextField();
		ExtUsername.setBounds(240, 136, 97, 20);
		getContentPane().add(ExtUsername);
		ExtUsername.setColumns(10);
		
		JLabel lblNewDuration = new JLabel("Confirm Username");
		lblNewDuration.setForeground(Color.YELLOW);
		lblNewDuration.setFont(new Font("Cooper Black", Font.BOLD, 13));
		lblNewDuration.setBounds(78, 138, 152, 14);
		getContentPane().add(lblNewDuration);
		
		JLabel labelCurrDuration = new JLabel("Username");
		labelCurrDuration.setForeground(Color.YELLOW);
		labelCurrDuration.setFont(new Font("Cooper Black", Font.BOLD, 13));
		labelCurrDuration.setBounds(78, 108, 152, 14);
		getContentPane().add(labelCurrDuration);
		
		JButton btnDelete = new JButton("Delete User");
		btnDelete.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				
				String iname=IntUsername.getText();
				String ename=ExtUsername.getText();
				
				if(iname.equals("user") && ename.equals("user"))
				{
					JOptionPane.showMessageDialog(frame, "User is successfully deleted");
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Invalid username");
				}
			}
		});
		btnDelete.setBounds(78, 187, 113, 23);
		getContentPane().add(btnDelete);
	}
}


