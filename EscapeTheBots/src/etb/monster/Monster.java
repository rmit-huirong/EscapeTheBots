// Huirong Huang - s3615907
package etb.monster;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import etb.game.Game;
import etb.graphics.Level;

public class Monster extends Rectangle {

	private static final long serialVersionUID = 1L;
	private Random randomNum;
	private int up = 0, down = 1, left = 2, right = 3;
	private int dir = -1;
	private int time = 0;
	private int speed = 4;
	private int unit = 1;
	
	private boolean poisoned = false;

	public boolean isPoisoned() {
		return poisoned;
	}

	public boolean isPoisonedTwo() {
		return poisonedTwo;
	}

	private boolean poisonedTwo = false;
	private long poisonTimeOne = 0;
	private long poisonTimeTwo = 0;
	private int foodCount = 0;
	private long tEnd = 0;
	private long timeElapsed = 0;

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public Monster(int x, int y) {
		randomNum = new Random();
		setBounds(x, y, 30, 30);
		dir = randomNum.nextInt(4);
	}

	public void tick() {
		if (dir == up) {
			if (canMove(x, y - speed / unit))
				y -= speed / unit;
			else
				dir = randomNum.nextInt(4);
		} else if (dir == down) {
			if (canMove(x, y + speed / unit))
				y += speed / unit;
			else
				dir = randomNum.nextInt(4);
		} else if (dir == left) {
			if (canMove(x - speed / unit, y))
				x -= speed / unit;
			else
				dir = randomNum.nextInt(4);
		} else if (dir == right) {
			if (canMove(x + speed / unit, y))
				x += speed / unit;
			else
				dir = randomNum.nextInt(4);
		}
		time = time + randomNum.nextInt(10);
		if (time % 100 == 0) {
			dir = randomNum.nextInt(4);
			time = 0;
		}
		Level level = Game.level;

		for (int i = 0; i < level.food.size(); i++) {
			if (this.intersects(level.food.get(i))) {
				timeElapsed = System.currentTimeMillis() - level.food.get(i).getTimePlaced();
				if (timeElapsed >= 1 * 1000) { // Time delay of 1s

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
						this.poisonedTwo = true;
						this.setUnit(this.unit + 2);
						foodCount++;
					} else {
						this.poisoned = true;
						poisonTimeOne = System.currentTimeMillis();
						foodCount++;
						this.setUnit(this.unit + 1);
					}

				}
			}
		}

		if (poisoned || poisonedTwo) {
			if (poisonedTwo) {
				tEnd = System.currentTimeMillis();
				if (tEnd - poisonTimeTwo >= 20 * 1000) {
					this.poisonedTwo = false;
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
					this.poisoned = false;
					foodCount--;
					this.setUnit(this.unit - 1);
				}
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(Game.spritesheet.getSprite(0, 16), x, y, width, height, null);
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

	public void setDirection(int dir) {
		this.dir = dir;
	}
	
	/*public void tick() {
	if (dir == up) {
		//if (canMove(x, y - speed / unit))
			y -= speed / unit;
		//else
			dir = randomNum.nextInt(4);
	} else if (dir == down) {
		//if (canMove(x, y + speed / unit))
			y += speed / unit;
		//else
			dir = randomNum.nextInt(4);
	} else if (dir == left) {
		//if (canMove(x - speed / unit, y))
			x -= speed / unit;
		//else
			dir = randomNum.nextInt(4);
	} else if (dir == right) {
		//if (canMove(x + speed / unit, y))
			x += speed / unit;
		//else
			dir = randomNum.nextInt(4);
	}
	time = time + randomNum.nextInt(10);
		if (time % 100 == 0) {
			dir = randomNum.nextInt(4);
			time = 0;
		}
	}*/
}

