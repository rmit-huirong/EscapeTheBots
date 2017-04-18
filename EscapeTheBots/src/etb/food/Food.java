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
	
	public Food(int x, int y){
		setBounds(x, y, 20, 20);
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}
}
