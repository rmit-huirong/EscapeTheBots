package etb.monster;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import etb.game.Game;
import graphics.Level;

public class MonsterTest {
	Monster monster_1 = new Monster(25, 87);
	Monster monster_2 = new Monster(38, 64);

	@Before
	public void setUp() throws Exception {
		monster_1.setDirection(1);
		monster_2.setDirection(2);
	}

	@Test
	public void testTick() {
		monster_1.tick();
		assertEquals(25, monster_1.getX(), 0.0);
		assertEquals(91, monster_1.getY(), 0.0);
		monster_2.tick();
		assertEquals(34, monster_2.getX(), 0.0);
		assertEquals(64, monster_2.getY(), 0.0);
	}
}
