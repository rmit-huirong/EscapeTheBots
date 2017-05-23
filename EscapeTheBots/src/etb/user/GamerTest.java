package etb.user;

import static org.junit.Assert.*;

import org.junit.Test;

public class GamerTest {
		Gamer gamer_1 = new Gamer("abc", "123");
		Gamer gamer_2 = new Gamer(null, null);
	@Test
	public void testRegister() {
	//	UserSystem.users.add(gamer_1);
		assertFalse(gamer_1.register()); //this user if same as initialized is false
		assertTrue(gamer_2.register());
	}

}