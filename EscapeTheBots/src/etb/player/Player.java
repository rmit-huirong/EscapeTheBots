package etb.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import etb.game.Game;
import etb.user.User;

public class Player extends Rectangle{
	

	private static final long serialVersionUID = 1L;
	private boolean up,down,right,left = false;
	public void setUp(boolean up) {
		this.up = up;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	private int speed = 4;
	
	public void tick(){
		if(up){
			y -= speed;
		}else if(down){
			y += speed;
		}else if(left){
			x -= speed;
		}else if(right){
			x += speed;
		} 
	}
	public Player(int x, int y){
		setBounds(x,y,30,30);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x,y,width,height);
	}

}
