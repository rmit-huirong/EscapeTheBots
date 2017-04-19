package etb.monster;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import etb.game.Game;

public class MonsterTest {
	Monster monster_1 = new Monster(100, 850);
	Monster monster_2 = new Monster(102, 850);
	Game game = new Game();
	@Before
	public void setUp() throws Exception {
		
		
	}

	@Test
	public void testTick() {
		
		monster_1.setDirection(1);
		monster_1.tick();
		assertEquals(100, monster_1.getX(), 0.0);
		assertEquals(854, monster_1.getY(), 0.0);
		monster_2.setDirection(2);
		monster_2.tick();
		assertEquals(98, monster_2.getX(), 0.0);
		assertEquals(850, monster_2.getY(), 0.0);
	}
}
