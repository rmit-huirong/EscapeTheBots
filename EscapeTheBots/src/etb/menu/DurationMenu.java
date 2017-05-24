package etb.menu;

import java.awt.*;

import javax.swing.*;

public class DurationMenu extends JFrame {
	private JTextField textCurrDuration;
	private JTextField textNewDuration;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DurationMenu window = new DurationMenu();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DurationMenu() {
		initialize();
	}
	
	private void initialize() {
		getContentPane().setBackground(Color.RED);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblDuration = new JLabel("Game Duration");
		lblDuration.setForeground(Color.YELLOW);
		lblDuration.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblDuration.setBounds(142, 57, 143, 14);
		getContentPane().add(lblDuration);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(258, 187, 79, 23);
		getContentPane().add(btnCancel);
		
		textCurrDuration = new JTextField();
		textCurrDuration.setBounds(292, 106, 45, 20);
		getContentPane().add(textCurrDuration);
		textCurrDuration.setColumns(10);
		
		textNewDuration = new JTextField();
		textNewDuration.setBounds(292, 136, 45, 20);
		getContentPane().add(textNewDuration);
		textNewDuration.setColumns(10);
		
		JLabel lblNewDuration = new JLabel("New Duration");
		lblNewDuration.setForeground(Color.YELLOW);
		lblNewDuration.setFont(new Font("Cooper Black", Font.BOLD, 13));
		lblNewDuration.setBounds(78, 138, 152, 14);
		getContentPane().add(lblNewDuration);
		
		JLabel labelCurrDuration = new JLabel("Current Duration");
		labelCurrDuration.setForeground(Color.YELLOW);
		labelCurrDuration.setFont(new Font("Cooper Black", Font.BOLD, 13));
		labelCurrDuration.setBounds(78, 108, 152, 14);
		getContentPane().add(labelCurrDuration);
		
		JButton btnChangeDuration = new JButton("Change Duration");
		btnChangeDuration.setBounds(78, 187, 113, 23);
		getContentPane().add(btnChangeDuration);
	}
}


