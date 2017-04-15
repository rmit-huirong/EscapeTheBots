// Huirong Huang - s3615907
package graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import etb.game.Game;
import etb.monster.Monster;
import graphics.Tile;

public class Level {
	public int width;
	public int height;

	public Tile[][] tiles;

	public List<Monster> monsters;

	public Level(String path) {
		monsters = new ArrayList<>();
		try {
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			this.width = map.getWidth() ;
			this.height = map.getHeight() ;
			int[] pixels = new int[width * height];
			map.getRGB(0, 0, width , height , pixels, 0, width);
			tiles = new Tile[width][height];
			for (int xx = 0; xx < width; xx++) {
				for (int yy = 0; yy < height; yy++) {
					int val = pixels[xx + (yy * width)];
					if (val == 0xFF0000FF) {
						// Tile
						tiles[xx][yy] = new Tile(xx  * 32, yy  * 32);
					}
				}
			}
			for (int i = 0; i < 50; i++) {
				monsters.add(new Monster(i*10+100, 540));
			}
		} catch (IOException e) {
			e.printStackTrace();
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
