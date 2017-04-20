/**
 * 
 */
package etb.player;

import static org.junit.Assert.*;

import org.junit.Test;

import etb.food.Food;
import etb.game.Game;
import etb.graphics.Level;

/**
 * @author Navod Bopitiya
 *
 */
public class PlayerTest {
	
	Game game = new Game();
	Level level = Game.level;

	@Test
	public void testInitialLocation() {
		int x = 500, y = 850;
		Player player = new Player(x, y);
		assertTrue(player.canMove(x, y));
		player = new Player(500, 500); // Player is outside bounds/grid
		x = (int) player.getX();
		y = (int) player.getY();
		assertFalse(player.canMove(x, y));
	}

	@Test
	public void testCanMove() {
		int x = 400, y = 850;
		Player player = new Player(x, y);
		x = 11;
		y = 7; // Grid position
		assertFalse(player.canMove(x, y));
		x = 631;
		y = 543; // Grid Position
		assertFalse(player.canMove(x, y));
		x = 500;
		y = 850; // Normal position (Hollow)
		assertTrue(player.canMove(x, y));
		x = 420;
		y = 459; // Normal position (Hollow)
		assertTrue(player.canMove(x, y));
	}

	@Test
	public void testMovePlayer() {
		int x = 500, y = 850;
		Player player = new Player(x, y);
		/* Going right */
		assertEquals(x, player.x);
		assertEquals(y, player.y);
		player.setRight(true);
		player.movePlayer(player.MAX_SPEED);
		assertEquals(x + player.MAX_SPEED, player.x);
		assertEquals(y, player.y);
		x = player.x;
		player.setRight(false);
		
		/*Going left */
		assertEquals(x, player.x);
		assertEquals(y, player.y);
		player.setLeft(true);
		player.movePlayer(player.MAX_SPEED);
		assertEquals(x - player.MAX_SPEED, player.x);
		assertEquals(y, player.y);
		x = player.x;
		player.setLeft(false);
		
		/*Going up */
		assertEquals(x, player.x);
		assertEquals(y, player.y);
		player.setUp(true);
		player.movePlayer(player.MAX_SPEED);
		assertEquals(y - player.MAX_SPEED, player.y);
		assertEquals(x, player.x);
		y = player.y;
		player.setUp(false);
		
		/*Going down */
		assertEquals(x, player.x);
		assertEquals(y, player.y);
		player.setDown(true);
		player.movePlayer(player.MAX_SPEED);
		assertEquals(y + player.MAX_SPEED, player.y);
		assertEquals(x, player.x);
		y = player.y;
		player.setDown(false);
	}

	@Test
	public void testPoisonPlayer() {
		int x = 500, y = 850;
		Player player = new Player(x, y);
		Food food = new Food(x + player.MAX_SPEED,y);
		level.food.add(food);
		level.player = player;
		level.player.setRight(true);
		level.player.movePlayer(level.player.currentSpeed);
		level.player.setRight(false);
		level.player.poisonPlayer(level);
		boolean check = level.player.poisoned;
		assertEquals(true,check);
		
	}

	@Test
	public void testCurePlayer() {
		int x = 500, y = 850;
		Player player = new Player(x,y);
		 /*Checking if first food item poisons player*/ 
		Food food = new Food(x+player.MAX_SPEED,y);
		this.level.food.add(food);
		player.setRight(true);
		player.tick();
		player.setRight(false);
		assertEquals(false,player.poisoned);
		assertEquals(false,player.poisonedTwo);
		
		/*Checking if second food item poisons player again*/ 
		player.setRight(true);
		Food foodTwo = new Food(player.x + player.MAX_SPEED,y);
		this.level.food.add(foodTwo);
		player.movePlayer(player.MAX_SPEED);
		player.tick();
		player.setRight(false);
		assertEquals(false,player.poisoned);
		assertEquals(false,player.poisonedTwo);
	}

}
