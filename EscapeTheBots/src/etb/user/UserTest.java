package etb.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

User user1 = new User("user", "pass");
User user2 = new User("USERSSS", "SDF");
	
	@Before
	public void setUp() throws Exception {	
		
	}
	
	@Test
	public void testLogin() {
	
		assertTrue(user1.login());
	}
}
