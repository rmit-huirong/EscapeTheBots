package etb.player;
/*
 * Author - Navod Bopitiya - s3617221
 */

import java.awt.Graphics;
import java.awt.Point;

import etb.entity.Entity;
import etb.food.Food;
import etb.game.Game;
import etb.graphics.Level;
import etb.graphics.Spritesheet;

public class Player extends Entity {

	private static final long serialVersionUID = 1L;
	private boolean up, down, right, left = false;
	
	
	protected final int MAX_SPEED = 4;


	private int foodCount = 0;

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

	public void tick() {
		setCurSpeed(MAX_SPEED/unit);
		movePlayer(curSpeed);

		Level level = Game.level;

		poisonEntity(level);

		cureEntity();

		
	}

	protected void movePlayer(int currentSpeed) {
		if (up) {
			if (canMove(x, y - currentSpeed)) {
				this.y -= currentSpeed;
			}
		}
		else if (down) {
			if (canMove(x, y + currentSpeed)) {
				this.y += currentSpeed;
			}
		}
		else if (left) {
			if (canMove(x - currentSpeed, y)) {
				this.x -= currentSpeed;
			}
		}
		else if (right) {
			if (canMove(x + currentSpeed, y)) {
				this.x += currentSpeed;
			}
		}
	}





	public Player(int x, int y) {
		super(x,y);
	}

	public void render(Graphics g) {
		Spritesheet sheet = Game.spritesheet;
		g.drawImage(sheet.getSprite(0, 0), x, y, width, height, null);
	}

	
	public boolean dropFood(Level level){
		Point point = getLocation();
		int x = (int) point.getX();
		int y = (int) point.getY();
		Food testFoodObject = new Food(x,y);

		if (foodCount < 2) {
			if (testFoodObject.canMove(x,y)) {
				level.food.add(testFoodObject);
				foodCount++;
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

}
