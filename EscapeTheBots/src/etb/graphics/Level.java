// Huirong Huang - s3615907
package etb.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import etb.food.Food;
import etb.game.Game;
import etb.graphics.Tile;
import etb.monster.Monster;
import etb.player.Player;

public class Level {
	public int width;
	public int height;

	public Tile[][] tiles;
	
	public List<Monster> monsters;
	public List<Food> food;
	public Player player;

/*level*/ 
	public Level(String path) {
		monsters = new ArrayList<>();
		food = new ArrayList<>();
		try {
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			this.width = map.getWidth();
			this.height = map.getHeight();
			int[] pixels = new int[width * height];
			tiles = new Tile[width][height];
			map.getRGB(0, 0, width, height, pixels, 0, width);
			for (int xx = 0; xx < width; xx++) {
				for (int yy = 0; yy < height; yy++) {
					int val = pixels[xx + (yy * width)];
					if (val == 0xFF000000) {
						// Tile
						tiles[xx][yy] = new Tile(xx * 32, yy * 32);
					}
					else if (val == 0xFF0000FF) {
						// Player
						player = new Player(Game.WIDTH / 2, Game.HEIGHT / 2);
						player.x = xx * 32;
						player.y = yy * 32;

					} else if (val == 0xFFFF0000) {
						// Monster
						monsters.add(new Monster(xx * 32, yy * 32));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void tick() {

		for (int i = 0; i < monsters.size(); i++) {
			monsters.get(i).tick();
		}
		for(int i = 0; i<food.size(); i++){
			food.get(i).tick();
		}
		player.tick();
		
		

	}

	public void render(Graphics g) {
		for (int i = 0; i < food.size(); i++) {
			food.get(i).render(g);
		}
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (tiles[x][y] != null)
					tiles[x][y].render(g);
			}
		}
		for (int i = 0; i < monsters.size(); i++) {
			monsters.get(i).render(g);
		}
		player.render(g);
	}
}
