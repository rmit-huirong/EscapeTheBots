package etb.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import etb.game.Game;
import etb.graphics.Level;

public abstract class Entity extends Rectangle {
	private long poisonTimeOne = 0;
	private long poisonTimeTwo = 0;
	private long tEnd = 0;
	private long timeElapsed = 0;
	private boolean poisonedTwo;
	private boolean poisoned;
	private int foodCount = 0;
	protected int unit = 1;
	protected int curSpeed = 4;

	public int getCurSpeed() {
		return curSpeed;
	}
	public void setCurSpeed(int curSpeed) {
		this.curSpeed = curSpeed;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public boolean isPoisoned() {
		return this.poisoned;
	}

	public boolean isPoisonedTwo() {
		return this.poisonedTwo;
	}
	

	

	public void setPoisoned(boolean poisoned) {
		this.poisoned = poisoned;
	}

	public void setPoisonedTwo(boolean poisonedTwo) {
		this.poisonedTwo = poisonedTwo;
	}

	public Entity(int x, int y) {
		setBounds(x, y, 30, 30);
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

	protected void cureEntity() {
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
																		// poison
																		// time
					setPoisoned(false);
					foodCount--;
					this.setUnit(this.unit - 1);
				}
			}
		}
	}
	
	public void poisonEntity(Level level) {
		for (int i = 0; i < level.food.size(); i++) {
			if (this.intersects(level.food.get(i))) {
				timeElapsed = System.currentTimeMillis() - level.food.get(i).getTimePlaced();
				if (timeElapsed >= 0.2 * 1000) { // Time delay of 0.5s

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
	
	protected abstract void tick();
	protected abstract void render(Graphics g);
}
