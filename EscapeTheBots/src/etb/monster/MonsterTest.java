package etb.monster;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import etb.game.Game;

public class MonsterTest {

	// screen is 1280x960
	// monster_1 & monster_3 is on the boundary of the bottom of the grid (inside the grid)
	// monster_2 & monster_4 is on the edge of the bottom of one of the blocks (outside the block)
	Monster monster_1 = new Monster(100, 960 - 32 * 2 - 30);
	Monster monster_2 = new Monster(102, 960 - 32 * 4);
	Monster monster_3 = new Monster(100, 960 - 32 * 2 - 30);
	Monster monster_4 = new Monster(102, 960 - 32 * 4);
	Game game = new Game();

	@Before
	public void setUp() throws Exception {

	}

	// test if the monster will move in the expected direction with his speed
	@Test
	public void testTick1() {
		// try to move monster_1 up, it works
		monster_1.setDirection(0);
		monster_1.tick();
		assertEquals(100, monster_1.getX(), 0.0);
		assertEquals(960 - 32 * 2 - 30 - 4, monster_1.getY(), 0.0);
		// try to move monster_2 down, it works
		monster_2.setDirection(1);
		monster_2.tick();
		assertEquals(102, monster_2.getX(), 0.0);
		assertEquals(960 - 32 * 4 + 4, monster_2.getY(), 0.0);
	}

	// test if the monster will move out of the grid or go inside the grid
	@Test
	public void testTick2() {
		// try to move monster_3 down, it doesn't work
		monster_3.setDirection(1);
		monster_3.tick();
		assertEquals(100, monster_3.getX(), 0.0);
		assertEquals(960 - 32 * 2 - 30, monster_3.getY(), 0.0);
		// try to move monster_4 up, it doesn't work
		monster_4.setDirection(0);
		monster_4.tick();
		assertEquals(102, monster_4.getX(), 0.0);
		assertEquals(960 - 32 * 4, monster_4.getY(), 0.0);
	}
}
