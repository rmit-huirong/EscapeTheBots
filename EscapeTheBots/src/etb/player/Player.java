/* Navod Bopitiya - s3617221 */

package etb.player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import etb.user.User;


public class Player extends User implements KeyListener {
	
	private int[][] position = new int[2][1];
	private int speed;
	private int score;
	
	public Player(String username, String password) {
		super(username, password);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

}