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
	private double speed = 1;
	private double unit = 1;

	public Monster(int x, int y) {
		random = new Random();
		setBounds(x, y, 32, 32);
		dir = random.nextInt(4);
	}

	public void tick() {
		if (dir == up)
			y-=speed*unit;
		if (dir == down)
			y+=speed*unit;
		if (dir == left)
			x-=speed*unit;
		if (dir == right)
			x+=speed*unit;
		time++;
		if (time == 60) {
			dir = random.nextInt(4);
			time = 0;
		}
	}

	public void render(Graphics g) {
		g.drawImage(Game.spritesheet.getSprite(0, 16), x, y, width, height, null);
	}
}
