package etb.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import etb.game.Game;

public class DurationMenu {
	private JTextField textCurrDuration;
	private JTextField textNewDuration;
	
	private JFrame frame;
	private JFrame previousFrame;
	public DurationMenu(JFrame previousFrame) {
		initialize();
		this.previousFrame = previousFrame;
		frame.setVisible(true);
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(27,91,127));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDuration = new JLabel("Game Duration ");
		lblDuration.setForeground(Color.YELLOW);
		lblDuration.setFont(new Font("Tekton Pro Ext", Font.BOLD, 17));
		lblDuration.setBounds(142, 57, 143, 14);
		frame.getContentPane().add(lblDuration);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				previousFrame.setVisible(true);
				
			}	
		});
		btnCancel.setBounds(258, 187, 79, 23);
		btnCancel.setBackground(Color.ORANGE);
		frame.getContentPane().add(btnCancel);
		
		textCurrDuration = new JTextField();
		textCurrDuration.setBounds(292, 106, 45, 20);
		frame.getContentPane().add(textCurrDuration);
		textCurrDuration.setColumns(10);
		textCurrDuration.setText(Integer.toString(Game.getDefaultCountDown()));
		textCurrDuration.setEditable(false);
		
		textNewDuration = new JTextField();
		textNewDuration.setBounds(292, 136, 45, 20);
		frame.getContentPane().add(textNewDuration);
		textNewDuration.setColumns(10);
		
		JLabel lblNewDuration = new JLabel("New Duration");
		lblNewDuration.setForeground(Color.YELLOW);
		lblNewDuration.setFont(new Font("Cooper Black", Font.BOLD, 13));
		lblNewDuration.setBounds(78, 138, 152, 14);
		frame.getContentPane().add(lblNewDuration);
		
		JLabel labelCurrDuration = new JLabel("Current Duration");
		labelCurrDuration.setForeground(Color.YELLOW);
		labelCurrDuration.setFont(new Font("Cooper Black", Font.BOLD, 13));
		labelCurrDuration.setBounds(78, 108, 152, 14);
		frame.getContentPane().add(labelCurrDuration);
		
		JButton btnChangeDuration = new JButton("Change Duration");
		btnChangeDuration.setBackground(Color.ORANGE);
		btnChangeDuration.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				//Change duration
				String value = textNewDuration.getText();
				changeDuration(value);
			}	
		});
		btnChangeDuration.setBounds(78, 187, 150, 23);
		frame.getContentPane().add(btnChangeDuration);
	}
	
	public boolean validateInt(String value){
		boolean isInteger = false;
		try{
			Integer.parseInt(value);
			//value is a valid integer
			isInteger = true;
		}catch(NumberFormatException e){
			//value is not an integer
			isInteger = false;
		}
		return isInteger;
	}

	protected void changeDuration(String value) {
		if(validateInt(value)){
			int duration = Integer.parseInt(value);
			if(duration <= 0 || duration>100){
				JOptionPane.showMessageDialog(frame, "Please enter a number that is above zero and below hundred");
			}else{
				Game.setDefaultCountDown(duration);
				JOptionPane.showMessageDialog(frame, "Time duration changed successfully to "+duration);
				frame.setVisible(false);
				previousFrame.setVisible(true);
			}
		}else{
			JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
		}
	}
}


