package blogz;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostAndUserTest {

	@Test
	public void testAddUser() {
		User u1 = new User("Joe123","myPW123");
		assertEquals("Joe123", u1.getUserName());
		assertEquals("myPW123", u1.getPassword());
		
		User u2 = new User("Jack","111999");
		assertEquals(null,u2.getUserName());
	}

}
