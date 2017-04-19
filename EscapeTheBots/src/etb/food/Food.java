/**
 * 
 */
package etb.food;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

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
	
	public void tick(){
	}
	
	public void render(Graphics g){
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}
}
