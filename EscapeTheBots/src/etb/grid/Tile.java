package etb.grid;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATIC STUFF HERE
	
	public static Tile[] tiles = new Tile[256];
	public static Tile emptyTile = new EmptyTile(0);
	public static Tile blockTile = new BlockTile(1);
	
	
	//CLASS

	public static final int TILEWIDTH = 50, TILEHEIGHT = 50;
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
		
		
	}
	
	public void tick(){
		
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);

	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
}