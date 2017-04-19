/**
 * 
 */
package etb.food;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import etb.game.Game;
import graphics.Level;

/**
 * @author Navod Bopitiya - s3617221
 *
 */
public class Food extends Rectangle {

	private static final long serialVersionUID = 1L;
	private long timePlaced = 0;
	
	public long getTimePlaced() {
		return timePlaced;
	}

	public Food(int x, int y){
		setBounds(x, y, 20, 20);
		timePlaced = System.currentTimeMillis();
	}
	
	public Food(Point point) {
		// TODO Auto-generated constructor stub
		x = (int) point.getX();
		y = (int) point.getY();
		setBounds(x,y,20,20);
		timePlaced = System.currentTimeMillis();
	}

	public void tick(){
	}
	
	public boolean canPlace(){
		Rectangle bounds = new Rectangle(x, y, width, height);
		Level level = Game.level;

		for (int xx = 0; xx < level.tiles.length; xx++) {
			for (int yy = 0; yy < level.tiles[0].length; yy++) {
				if (level.tiles[xx][yy] != null) {
					if (bounds.intersects(level.tiles[xx][yy])) {
						return false;
					}

				}
			}
		}
		return true;
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}
}
