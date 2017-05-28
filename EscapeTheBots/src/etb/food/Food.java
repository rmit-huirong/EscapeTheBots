/**
 * 
 */
package etb.food;

import java.awt.Color;
import java.awt.Graphics;

import etb.entity.Entity;
import etb.game.Game;
import etb.graphics.Level;

/*
 * Author - Navod Bopitiya - s3617221
 */
public class Food extends Entity {

	private static final long serialVersionUID = 1L;
	private long timePlaced = 0;

	public long getTimePlaced() {
		return timePlaced;
	}

	public Food(int x, int y) {
		super(x,y);
		timePlaced = System.currentTimeMillis();
	}

	public void tick() {
		foodTimeout();
		canMove(x,y);
	}

	public void foodTimeout() {
		Level level = Game.level;
		for (int i = 0; i < level.food.size(); i++) {
			long tEnd = System.currentTimeMillis();
			if (tEnd - level.food.get(i).getTimePlaced() >= 20 * 1000) {
				System.out.println(tEnd - level.food.get(i).getTimePlaced());
				level.food.remove(i);

			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}
}
