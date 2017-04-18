// Huirong Huang - s3615907
package graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import etb.food.Food;
import etb.game.Game;
import etb.monster.Monster;
import etb.player.Player;
import graphics.Tile;

public class Level {
	public int width;
	public int height;

	public Tile[][] tiles;

	public List<Monster> monsters;
	public Player player;
	public static List<Food> food;

	public Level(String path) {
		monsters = new ArrayList<>();
		food = new ArrayList<>();
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
					if (val == 0xFF000000) {
						// Tile
						tiles[xx][yy] = new Tile(xx  * 32, yy  * 32);
					}
				}
			}
			for (int i = 0; i < 50; i++) {
				monsters.add(new Monster(i*10+100, 850));
			}
			player = new Player(100,850);
			food.add(new Food(500,850));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void tick() {
		player.tick();
		for (int i = 0; i < 50; i++) {
			monsters.get(i).tick();
		}
		
	}

	public void render(Graphics g) {
		for(int i = 0; i < food.size(); i++){
			food.get(i).render(g);
		}
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (tiles[x][y] != null)
					tiles[x][y].render(g);
			}
		}
		for (int i = 0; i < 50; i++) {
			monsters.get(i).render(g);
		}
		player.render(g);
		
		
	}
}
