package etb.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserSystemTest {
	
	UserSystem us = new UserSystem();
	@Test
	public void testAddGamer() {
		assertTrue(us.addGamer());
	}

	@Test
	public void testLogin() {
		us.addGamer();
		assertTrue(us.login());
		assertFalse(us.login());
	}
}
