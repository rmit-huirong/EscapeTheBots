package etb.user;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class LoginTest {
	
	User user = new User("user", "pass");
	
	@Before
	public void setUp() throws Exception {		
	}
	
	@Test
	public void testLoginAuthorisation() {
		users.add(user);
	}

}
