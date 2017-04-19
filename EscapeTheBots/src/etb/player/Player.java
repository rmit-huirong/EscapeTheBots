package etb.player;
//Author - Navod Bopitiya - s3617221

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import etb.game.Game;
import graphics.Level;

public class Player extends Rectangle {

	private static final long serialVersionUID = 1L;
	private boolean up, down, right, left = false;
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

	public void tick() {
		if (up) {
			if (canMove(x, y - speed / unit)) {
				y -= speed / unit;
			}
		} else if (down) {
			if (canMove(x, y + speed / unit)) {
				y += speed / unit;
			}
		} else if (left) {
			if (canMove(x - speed, y)) {
				x -= speed / unit;
			}
		} else if (right) {
			if (canMove(x + speed, y)) {
				x += speed / unit;
			}
		}
		Level level = Game.level;

		for (int i = 0; i < level.food.size(); i++) {
			if (this.intersects(level.food.get(i))) {
				timeElapsed = System.currentTimeMillis() - level.food.get(i).getTimePlaced();
				if (timeElapsed >= 1 * 1000) { //Time delay of 1s

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

	public Player(int x, int y) {
		setBounds(x, y, 30, 30);
	}

	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
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

}
