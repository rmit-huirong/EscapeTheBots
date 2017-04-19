/**
 * 
 */
package etb.player;

import static org.junit.Assert.*;

import org.junit.Test;

import etb.food.Food;
import etb.game.Game;

/**
 * @author Navod Bopitiya
 *
 */
public class PlayerTest {

	Player player = new Player(Game.WIDTH / 2, Game.HEIGHT / 2);
	int x = (int)player.getX();
	int y = (int)player.getY();
	Game game = new Game();
	Food food = new Food(player.getLocation());
	Food foodTwo = new Food(player.getLocation());
	
	@Test
	public void testInitialLocation(){
		assertTrue(player.canMove(x, y));
		player = new Player(500,500); //Player is outside bounds/grid
		x = (int)player.getX();
		y = (int)player.getY();
		assertFalse(player.canMove(x, y));
	}
	
	@Test
	public void testCanMove(){
		int x,y;
		x = 11; y = 7; // Grid position
		assertFalse(player.canMove(x, y));
		x = 631; y = 543; //Grid Position
		assertFalse(player.canMove(x, y));
		x = 500; y = 850; //Normal position (Hollow)
		assertTrue(player.canMove(x, y));	
		x = 420; y = 459; //Normal position (Hollow)
		assertTrue(player.canMove(x, y));		
	}
	
	@Test
	public void testTick(){
		assertTrue(player.isPoisoned());
		assertTrue(player.isPoisonedTwo());
	}

}
