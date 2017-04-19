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

	Player player = new Player(Game.WIDTH / 2, Game.HEIGHT / 2);
	int x = (int) player.getX();
	int y = (int) player.getY();
	Game game = new Game();
	Food food = new Food(player.getLocation());
	Food foodTwo = new Food(player.getLocation());
	Level level = Game.level;

	@Test
	public void testInitialLocation() {
		assertTrue(player.canMove(x, y));
		player = new Player(500, 500); // Player is outside bounds/grid
		x = (int) player.getX();
		y = (int) player.getY();
		assertFalse(player.canMove(x, y));
	}

	@Test
	public void testCanMove() {
		int x, y;
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
		player = new Player(x, y);
		/* Going right */
		player.setRight(true);
		player.movePlayer(player.MAX_SPEED);
		assertEquals(x + player.MAX_SPEED, player.x);
		x = player.x;
		player.setRight(false);
		
		/*Going left */
		player.setLeft(true);
		player.movePlayer(player.MAX_SPEED);
		assertEquals(x - player.MAX_SPEED, player.x);
		x = player.x;
		player.setLeft(false);
		
		/*Going up */
		player.setUp(true);
		player.movePlayer(player.MAX_SPEED);
		assertEquals(y - player.MAX_SPEED, player.y);
		y = player.y;
		player.setUp(false);
		
		/*Going down */
		player.setDown(true);
		player.movePlayer(player.MAX_SPEED);
		assertEquals(y + player.MAX_SPEED, player.y);
		y = player.y;
		player.setDown(false);
	}

	@Test
	public void testPoisonPlayer() {
		int x = 500, y = 850;
		player = new Player(x,y);
		/* Checking if first food item poisons player */
		Food food = new Food(x+player.MAX_SPEED,y);
		this.level.food.add(food);
		player.setRight(true);
		player.poisonPlayer(level);
		player.setRight(false);
		assertEquals(true,player.poisoned);
		assertEquals(false,player.poisonedTwo);
		
		/*Checking if second food item poisons player again */
		player.setRight(true);
		Food foodTwo = new Food(player.x + player.MAX_SPEED,y);
		this.level.food.add(foodTwo);
		player.movePlayer(player.MAX_SPEED);
		player.setRight(false);
		player.poisonPlayer(this.level);
		assertEquals(true,player.poisoned);
		assertEquals(true,player.poisonedTwo);
	}

	@Test
	public void testCurePlayer() {
		int x = 500, y = 850;
		player = new Player(x,y);
		/* Checking if first food item poisons player */
		Food food = new Food(x+player.MAX_SPEED,y);
		this.level.food.add(food);
		player.setRight(true);
		player.tick();
		player.setRight(false);
		assertEquals(false,player.poisoned);
		assertEquals(false,player.poisonedTwo);
		
		/*Checking if second food item poisons player again */
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
