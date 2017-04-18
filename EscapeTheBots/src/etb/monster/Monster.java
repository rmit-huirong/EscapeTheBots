// Huirong Huang - s3615907
package etb.monster;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import etb.game.Game;
import graphics.Level;

public class Monster extends Rectangle {

	private Random random;
	private int up = 0, down = 1, left = 2, right = 3;
	private int dir = -1;
	private int time = 0;
	private int speed = 1;
	private int unit = 1;

	public Monster(int x, int y) {
		random = new Random();
		setBounds(x, y, 32, 32);
		dir = random.nextInt(4);
	}

	public void tick() {
		if (dir == up) {
			if (canMove(x, y-1))
				y -= speed * unit;
			else
				dir = random.nextInt(4);
		} 
		else if (dir == down) {
			if (canMove(x, y+1))
				y += speed * unit;
			else
				dir = random.nextInt(4);
		} 
		else if (dir == left) {
			if (canMove(x-1, y))
				x -= speed * unit;
			else
				dir = random.nextInt(4);
		} 
		else if (dir == right) {
			if (canMove(x+1, y))
				x += speed * unit;
			else
				dir = random.nextInt(4);
		} 
		time = time + random.nextInt(10);
		if (time % 100 == 0) {
			dir = random.nextInt(4);
			time = 0;
		}
	}

	public void render(Graphics g) {
		g.drawImage(Game.spritesheet.getSprite(0, 16), x, y, width, height, null);
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

