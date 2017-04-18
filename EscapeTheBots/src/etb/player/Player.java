package etb.player;
//Author - Navod Bopitiya - s3617221

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import etb.game.Game;
import etb.user.User;
import graphics.Level;

public class Player extends Rectangle {

	private static final long serialVersionUID = 1L;
	private boolean up, down, right, left = false;
	private int unit = 1;
	private boolean poisoned = false;
	private long poisonTime = 0;
	
	public void setUnit(int unit) {
		this.unit = unit;
	}

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

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void tick(){
		if(up){
			if(canMove(x,y - speed/unit)){
				y -= speed/unit;
			}
		}else if(down){
			if(canMove(x,y + speed/unit)){
				y += speed/unit;
			}
		}else if(left){
			if(canMove(x - speed,y)){
				x -= speed/unit;
			}
		}else if(right){
			if(canMove(x + speed,y)){
				x += speed/unit;
			}
		} 
		Level level = Game.level;
		
		for(int i = 0; i < level.food.size(); i++){
			if(this.intersects(level.food.get(i))){
				level.food.remove(i);
				this.poisoned = true;
				poisonTime = System.currentTimeMillis();
				this.setUnit(unit + 1);
			}
		}
		
		if(poisoned){
			long tEnd = System.currentTimeMillis();
			if(tEnd - poisonTime >= 20 * 1000){
				this.poisoned = false;
				this.setUnit(1);
			}
		}
	}

	public Player(int x, int y) {
		setBounds(x, y, 30, 30);
	}

	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
	}

	private boolean canMove(int nextx, int nexty) {
		Rectangle bounds = new Rectangle(nextx, nexty, width, height);
		Level level = Game.level;

		for (int xx = 0; xx < level.tiles.length; xx++) {
			for (int yy = 0; yy < level.tiles[0].length; yy++) {
				if (level.tiles[xx][yy] != null) {
					if (bounds.intersects(level.tiles[xx][yy])) {
						return false;
					}
				
				}
			}
		}
		return true;
	}

}
