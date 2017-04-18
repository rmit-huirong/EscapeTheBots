package etb.grid;

import java.awt.Graphics;

import etb.grid.Tile;
import etb.display.Utils;

public class World {
	
	private static int width;
	private static int height; 
	private static int[][] tiles;
	
	public World(String path){
		loadWorld(path);
		
	}
	
	public void tick(){
		
	}
	
	public static void render(Graphics g){
		for(int y = 0; y < height; y++)
			for(int x = 0; x <width; x++)
			{
				getTile(x, y).render(g, x * Tile.TILEWIDTH, y *Tile.TILEHEIGHT);
			}
	}
	
	public static Tile getTile(int x, int y){
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.blockTile;
		return t;
		
	}
	public static void loadWorld(String path){
	
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		
		tiles = new int[width][height];
		
		for(int y = 0; y < height; y++)
			for(int x = 0; x < width; x++){
				
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 2]);
			}
		
		
	}

}
