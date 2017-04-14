// Huirong Huang - s3615907
package graphics;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import etb.monster.Monster;
import graphics.Tile;

public class Level {
	public int width = 20*2;
	public int height = 15*2;

	public Tile[][] tiles;

	public List<Monster> monsters;

	public Level() {
		tiles = new Tile[width][height];
		monsters = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			monsters.add(new Monster(500, 500));
			for (int xx = 0; xx < width; xx++) {
				for (int yy = 0; yy < height; yy++) {
					if (xx == 0 || yy == 0 || xx == width - 1 || yy == height - 1) {
						tiles[xx][yy] = new Tile(xx * 32, yy * 32);
					}
				}
			}
		}
	}

	public void tick() {
		for (int i = 0; i < 50; i++) {
			monsters.get(i).tick();
		}
	}

	public void render(Graphics g) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (tiles[x][y] != null)
					tiles[x][y].render(g);
			}
		}
		for (int i = 0; i < 50; i++) {
			monsters.get(i).render(g);
		}
	}
}
