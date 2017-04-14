// Huirong Huang - s3615907
package etb.food;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class Food0Test{
	
	Food0 food_1 = new Food0(5, 9);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSetX() {
		assertEquals(5, food_1.getX());
	}

	@Test
	public void testSetY() {
		assertEquals(9, food_1.getY());
	}
}
