// Huirong Huang - s3615907
package etb.monster;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import etb.game.Game;
import etb.graphics.Level;
import etb.graphics.Spritesheet;
import etb.player.Player;
import etb.strategy.Strategy;

public class Monster extends Rectangle {

	private static final long serialVersionUID = 1L;

	private final int SPEED_MAX = 4;

	private Random randomNum;
	private int up = 0, down = 1, left = 2, right = 3;
	private int random = 0, smart = 1, find_path = 2, find_another_path = 3;
	private int state = random;
	private int dir = -1;
	private int lastDir = -1;
	private int time = 0;
	private int curSpeed = 4;
	private int unit = 1;

	private boolean poisoned = false;

	private boolean poisonedTwo = false;
	private long poisonTimeOne = 0;
	private long poisonTimeTwo = 0;
	private int foodCount = 0;
	private long tEnd = 0;
	private long timeElapsed = 0;

	public void setCurSpeed(int unit) {
		curSpeed = SPEED_MAX / unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getCurSpeed() {
		return curSpeed;
	}

	public void setLastDir(int lastDir) {
		this.lastDir = lastDir;
	}

	public int getLastDir() {
		return lastDir;
	}

	public Monster(int x, int y) {
		randomNum = new Random();
		setBounds(x, y, 30, 30);
		dir = randomNum.nextInt(4);
	}

	public void tick() {
		int curSpeed = SPEED_MAX / unit;
		Level level = Game.level;
		
		if (state == random)
		{
			if(dir == right)
			{
				if(canMove(x+curSpeed, y))
				{
					x+=curSpeed;
				}
				else
				{
					dir = randomNum.nextInt(4);
				}
			}
			else if (dir == left)
			{
				if(canMove(x-curSpeed, y))
				{
					x-=curSpeed;
				}
				else
				{
					dir = randomNum.nextInt(4);
				}
			}
			else if (dir == up)
			{
				if(canMove(x, y-curSpeed))
				{
					y-=curSpeed;
				}
				else
				{
					dir = randomNum.nextInt(4);
				}
			}
			else if (dir == down)
			{
				if(canMove(x, y+curSpeed))
				{
					y+=curSpeed;
				}
				else
				{
					dir = randomNum.nextInt(4);
				}
			}
			time++;
			if(time == 180)
			{
				state = smart;
				time = 0;
			}
		}
		else if (state == smart)
		{
			//follow the player
			
			boolean move = false;
			
			if (x<level.player.x)
			{
				if (canMove(x+curSpeed, y))
				{
					x+=curSpeed;
					move = true;
					lastDir = right;
				}
			}
			if (x>level.player.x)
			{
				if (canMove(x-curSpeed, y))
				{
					x-=curSpeed;
					move = true;
					lastDir =left;
				}
			}
			if (y<level.player.y)
			{
				if (canMove(x, y+curSpeed))
				{
					y+=curSpeed;
					move = true;
					lastDir = down;
				}
			}
			if (y>level.player.y)
			{
				if (canMove(x, y-curSpeed))
				{
					y-=curSpeed;
					move = true;
					lastDir = up;
				}
			}
			
			if(x==level.player.x && y== level.player.y) move = true;
			
			
			if (!move)
			{
				state = find_path;
			}
			time++;
			if(time == 300)
			{
				state = random;
				time = 0;
			}
		}
		else if (state == find_path)
		{
			if (lastDir == right)
			{
				if(y<level.player.y)
				{
					if(canMove(x, y+curSpeed))
					{
						y+=curSpeed;
						state = smart;
					}
					else if(canMove(x+curSpeed, y))
					{
						x+=curSpeed;
					}
					else if (canMove(x-curSpeed, y))
					{
						x-=curSpeed;
						lastDir = left;
						state = find_another_path;
					}
				}
				else
				{
					if(canMove(x, y-curSpeed))
					{
						y-=curSpeed;
						state = smart;
					}
					else if(canMove(x+curSpeed, y))
					{
						x+=curSpeed;
					}
					else if (canMove(x-curSpeed, y))
					{
						x-=curSpeed;
						lastDir = left;
						state = find_another_path;
					}
				}
			}
			else if (lastDir == left)
			{
				if(y<level.player.y)
				{
					if(canMove(x, y+curSpeed))
					{
						y+=curSpeed;
						state = smart;
					}
					else if(canMove(x-curSpeed, y))
					{
						x-=curSpeed;
					}
					else if(canMove(x+curSpeed, y))
					{
						x+=curSpeed;
						lastDir = right;
						state = find_another_path;
					}
				}
				else
				{
					if(canMove(x, y-curSpeed))
					{
						y-=curSpeed;
						state = smart;
					}
					else if(canMove(x-curSpeed, y))
					{
						x-=curSpeed;
					}
					else if(canMove(x+curSpeed, y))
					{
						x+=curSpeed;
						lastDir = right;
						state = find_another_path;
					}
				}
			}
			else if (lastDir == up)
			{
				if(x<level.player.x)
				{
					if(canMove(x+curSpeed, y))
					{
						x+=curSpeed;
						state = smart;
					}
					else if(canMove(x, y-curSpeed))
					{
						y-=curSpeed;
					}
					else if(canMove(x, y+curSpeed))
					{
						y+=curSpeed;
						lastDir = down;
						state = find_another_path;
					}
				}
				else
				{
					if(canMove(x-curSpeed, y))
					{
						x-=curSpeed;
						state = smart;
					}
					else if(canMove(x, y-curSpeed))
					{
						y-=curSpeed;
					}
					else if(canMove(x, y+curSpeed))
					{
						y+=curSpeed;
						lastDir = down;
						state = find_another_path;
					}
				}
			}
			else if (lastDir == down)
			{
				if(x<level.player.x)
				{
					if(canMove(x+curSpeed, y))
					{
						x+=curSpeed;
						state = smart;
					}
					else if(canMove(x, y+curSpeed))
					{
						y+=curSpeed;
					}
					else if(canMove(x, y-curSpeed))
					{
						y-=curSpeed;
						lastDir = up;
						state = find_another_path;
					}
				}
				else
				{
					if(canMove(x-curSpeed, y))
					{
						x-=curSpeed;
						state = smart;
					}
					else if(canMove(x, y+curSpeed))
					{
						y+=curSpeed;
					}
					else if(canMove(x, y-curSpeed))
					{
						y-=curSpeed;
						lastDir = up;
						state = find_another_path;
					}
				}
			}			
		}
		else if (state == find_another_path)
		{
			boolean movefirst = false;
			
			if(lastDir == right)
			{
				if(y<level.player.y)
				{
					if(canMove(x, y+curSpeed))
					{
						y+=curSpeed;
						state = find_path;
						movefirst = true;
					}
				}
				else
				{
					if(canMove(x, y-curSpeed))
					{
						y-=curSpeed;
						state = find_path;
						movefirst = true;
					}
				}
				if(!movefirst)
				{
					x+=curSpeed;
				}
			}
			if(lastDir == left)
			{
				if(y<level.player.y)
				{
					if(canMove(x, y+curSpeed))
					{
						y+=curSpeed;
						state = find_path;
						movefirst = true;
					}
				}
				else
				{
					if(canMove(x, y-curSpeed))
					{
						y-=curSpeed;
						state = find_path;
						movefirst = true;
					}
				}
				if(!movefirst)
				{
					x-=curSpeed;
				}
			}
			if(lastDir == up)
			{
				if(x<level.player.x)
				{
					if(canMove(x+curSpeed, y))
					{
						x+=curSpeed;
						state = find_path;
						movefirst = true;
					}
				}
				else
				{
					if(canMove(x-curSpeed, y))
					{
						x-=curSpeed;
						state = find_path;
						movefirst = true;
					}
				}
				if(!movefirst)
				{
					y-=curSpeed;
				}
			}
			if(lastDir == down)
			{
				if(x<level.player.x)
				{
					if(canMove(x+curSpeed, y))
					{
						x+=curSpeed;
						state = find_path;
						movefirst = true;
					}
				}
				else
				{
					if(canMove(x-curSpeed, y))
					{
						x-=curSpeed;
						state = find_path;
						movefirst = true;
					}
				}
				if(!movefirst)
				{
					y+=curSpeed;
				}
			}
		}
		poisonMonster(level);

		cureMonster();
	}

	public void render(Graphics g) {
		Spritesheet sheet = Game.spritesheet;
		g.drawImage(sheet.getSprite(0, 16), x, y, width, height, null);
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

	private void cureMonster() {
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

	private void poisonMonster(Level level) {
		for (int i = 0; i < level.food.size(); i++) {
			if (this.intersects(level.food.get(i))) {
				timeElapsed = System.currentTimeMillis() - level.food.get(i).getTimePlaced();
				if (timeElapsed >= 0.5 * 1000) { // Time delay of 1s

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
	}
}
