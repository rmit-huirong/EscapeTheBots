/**
 * 
 */
package etb.food;

import static org.junit.Assert.*;

import org.junit.Test;

import etb.game.Game;
import etb.graphics.Level;

/**
 * @author Navod Bopitiya
 *
 */
public class FoodTest {
	
	Game game = new Game();
	Level level = Game.level;
	
	@Test
	public void testCanPlace() {
		int x, y;
		x = 11;
		y = 7; // Grid position
		Food food = new Food(x,y);
		assertFalse(food.canPlace());
		x = 631;
		y = 543; // Grid Position
		food = new Food(x,y);
		assertFalse(food.canPlace());
		x = 500;
		y = 850; // Normal position (Hollow)
		food = new Food(x,y);
		assertTrue(food.canPlace());
		x = 420;
		y = 459; // Normal position (Hollow)
		food = new Food(x,y);
		assertTrue(food.canPlace());
	}

	@Test
	public void testFoodTimeout(){
		int x,y;
		x = 500; y = 850;
		level.food.add(new Food(x,y));
		if(game.getCountDown() <= game.getCountDown() - 20){
			assertNull(level.food.get(0));
		}
		
	}
}
