package etb.monster;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import etb.util.Timer;

public class MonsterTest {

	Monster monster_1 = new Monster(5, 7, "south", 4);
	Monster monster_2 = new Monster(2, 8, "east", 4);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSetX() {
		assertEquals(5, monster_1.getX());
		assertEquals(2, monster_2.getX());
	}

	@Test
	public void testSetY() {
		assertEquals(7, monster_1.getY());
		assertEquals(8, monster_2.getY());
	}

	@Test
	public void testSetDirection() {
		assertEquals("south", monster_1.getDirection());
		assertEquals("east", monster_2.getDirection());
	}

	@Test
	public void testSetSpeed() {
		assertEquals(4, monster_1.getSpeed(), 0.0);
		assertEquals(4, monster_2.getSpeed(), 0.0);
	}

	@Test
	public void testMove() {
		monster_1.move("south");
		assertEquals(5, monster_1.getX());
		assertEquals(8, monster_1.getY());
		assertEquals("south", monster_1.getDirection());
		monster_2.move("east");
		assertEquals(3, monster_2.getX());
		assertEquals(8, monster_2.getY());
		assertEquals("east", monster_2.getDirection());
	}
	
	@Ignore
	public void testEatFood() {
		Timer time = new Timer(2);
		monster_1.eatFood();
		assertEquals(2, monster_1.getSpeed(), 0.0);
		monster_1.eatFood();
		assertEquals(1, monster_1.getSpeed(), 0.0);
	}
}
