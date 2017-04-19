package etb.grid;

import java.awt.Graphics;

import etb.grid.Tile1;
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
				getTile(x, y).render(g, x * Tile1.TILEWIDTH, y *Tile1.TILEHEIGHT);
			}
	}
	
	public static Tile1 getTile(int x, int y){
		
		Tile1 t = Tile1.tiles[tiles[x][y]];
		if(t == null)
			return Tile1.blockTile;
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