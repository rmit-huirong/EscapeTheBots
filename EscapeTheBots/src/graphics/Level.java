// Huirong Huang - s3615907
package graphics;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import etb.monster.Monster;

public class Level {
	public int width;
	public int height;

	public List<Monster> monsters;

	public Level() {
		monsters = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			monsters.add(new Monster(500, 500));
		}
	}

	public void tick() {
		for (int i = 0; i < 50; i++) {
			monsters.get(i).tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < 50; i++) {
			monsters.get(i).render(g);
		}
	}
}
