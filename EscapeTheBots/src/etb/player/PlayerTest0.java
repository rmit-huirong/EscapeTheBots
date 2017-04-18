/**
 * 
 */
package etb.player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Navod Bopitiya
 *
 */
public class PlayerTest0 {
	
	
	Player0 player = new Player0("user","pass");
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testInitialX() {
		assertEquals(10, player.getX());
	}
	
	@Test
	public void testInitialY() {
		assertEquals(10, player.getY());
	}
	
	@Test
	public void testMove() {
		player.move("west");
		assertEquals(9, player.getX());
		assertEquals(10, player.getY());
		player.move("north");
		assertEquals(9,player.getX());
		assertEquals(9, player.getY());
		player.move("south");
		assertEquals(9, player.getX());
		assertEquals(10, player.getY());
		player.move("east");
		assertEquals(10, player.getX());
		assertEquals(10, player.getY());
	}
	
}
