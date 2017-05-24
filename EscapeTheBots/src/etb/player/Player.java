package etb.player;
/*
 * Author - Navod Bopitiya - s3617221
 */

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import etb.food.Food;
import etb.game.Game;
import etb.graphics.Level;
import etb.graphics.Spritesheet;

public class Player extends Rectangle {

	private static final long serialVersionUID = 1L;
	private boolean up, down, right, left = false;
	private int unit = 1;
	protected boolean poisoned;
	protected final int MAX_SPEED = 4;
	protected int currentSpeed = MAX_SPEED / unit;

	private long poisonTimeOne = 0;
	private long poisonTimeTwo = 0;
	private int foodCount = 0;
	private long tEnd = 0;
	private long timeElapsed = 0;

	public boolean isPoisoned() {
		return this.poisoned;
	}

	public boolean isPoisonedTwo() {
		return this.poisonedTwo;
	}

	protected boolean poisonedTwo;

	public void setPoisoned(boolean poisoned) {
		this.poisoned = poisoned;
	}

	public void setPoisonedTwo(boolean poisonedTwo) {
		this.poisonedTwo = poisonedTwo;
	}

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

	public void tick() {
		currentSpeed = MAX_SPEED / unit;
		movePlayer(currentSpeed);

		Level level = Game.level;

		poisonPlayer(level);

		curePlayer();

		
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

	protected void curePlayer() {
		if (poisoned || poisonedTwo) {
			if (poisonedTwo) {
				tEnd = System.currentTimeMillis();
				if (tEnd - poisonTimeTwo >= 20 * 1000) {
					setPoisonedTwo(false);
					foodCount--;
					this.setUnit(this.unit - 2);
					poisonTimeOne = System.currentTimeMillis();
				}
			} else if (poisoned && poisonedTwo == false) {
				tEnd = System.currentTimeMillis();
				if (tEnd - poisonTimeOne >= 20 * 1000 - timeElapsed) {// Removing
																		// time
																		// that
																		// has
																		// already
																		// gone
																		// from
																		// the
																		// first
																		// poison
																		// time
					setPoisoned(false);
					foodCount--;
					this.setUnit(this.unit - 1);
				}
			}
		}
	}

	protected void poisonPlayer(Level level) {
		for (int i = 0; i < level.food.size(); i++) {
			if (this.intersects(level.food.get(i))) {
				timeElapsed = System.currentTimeMillis() - level.food.get(i).getTimePlaced();
				if (timeElapsed >= 0.5 * 1000) { // Time delay of 0.5s

					level.food.remove(i);
					if (foodCount == 1) {
						poisonTimeTwo = System.currentTimeMillis();
						tEnd = System.currentTimeMillis();
						if (tEnd - poisonTimeOne <= 20 * 1000) { // Finding
																	// timeElapsed
																	// in order
																	// to keep
																	// the time
																	// from Food
																	// one
																	// intact
							timeElapsed = tEnd - poisonTimeOne;
						}
						setPoisonedTwo(true);
						this.setUnit(this.unit + 2);
						foodCount++;
					} else {
						setPoisoned(true);
						poisonTimeOne = System.currentTimeMillis();
						foodCount++;
						this.setUnit(this.unit + 1);
					}

				}
			}
		}
	}

	public Player(int x, int y) {
		setBounds(x, y, 30, 30);
	}

	public void render(Graphics g) {
		Spritesheet sheet = Game.spritesheet;
		g.drawImage(sheet.getSprite(0, 0), x, y, width, height, null);
	}

	public boolean canMove(int nextx, int nexty) {
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
	
	public boolean dropFood(Level level){
		Point point = getLocation();
		Food testFoodObject = new Food(point);

		if (foodCount < 2) {
			if (testFoodObject.canPlace()) {
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
