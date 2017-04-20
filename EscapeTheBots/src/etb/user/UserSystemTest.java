package etb.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserSystemTest {
	
	UserSystem us = new UserSystem();


	@Test
	public void testLogin() {
		us.register();
		assertFalse(us.login());
		assertTrue(us.login());
		
	}
}