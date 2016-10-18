package blogz;

import static org.junit.Assert.*;
import org.junit.Test;

import java.awt.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.PatternSyntaxException;

public class PostAndUserTest {
	
	private static boolean initialized = false;
	
	public PostAndUserTest() {
		if (!initialized) {
            // initialize your instance properties here
			//?????????????
            initialized = true;
        }
	}

	//Add new user test
	@Test
	public void testAddUser() {
		User u = new User("Joe123","myPW123");
		assertEquals("Joe123", u.getUserName());
		assertEquals("myPW123", u.getPassword());
		
	}
	
	//Username exception test
	@Test
	public void testInvalidUsername() {
		//too short
		try {
			new User("abc","111999");
			fail("Exception was not thrown for invalid username");
		}
		//catch (IllegalArgumentException e) {
		catch (PatternSyntaxException e) {
			assertTrue(true);
		}
		
		//too long
		try {
			new User("abc123xyz4567","111999");
			fail("Exception was not thrown for invalid username");
		}
		//catch (IllegalArgumentException e) {
		catch (PatternSyntaxException e) {
			assertTrue(true);
		}
		
		//does not start with letter
		try {
			new User("9abcde9","111999");
			fail("Exception was not thrown for invalid username");
		}
		//catch (IllegalArgumentException e) {
		catch (PatternSyntaxException e) {
			assertTrue(true);
		}
		
		//uses illegal character
		try {
			new User("abc3#ef","111999");
			fail("Exception was not thrown for invalid username");
		}
		//catch (IllegalArgumentException e) {
		catch (PatternSyntaxException e) {
			assertTrue(true);
		}
	}
	
	//Add new Post test
		@Test
		public void testAddPost() {
			Date now = Calendar.getInstance().getTime();
			Post p = new Post("My Test Blog Post","This is what it says...","Tom Jones");
			System.out.println(now);
			System.out.println(p.getCreated());
			assertEquals("My Test Blog Post", p.getTitle());
			assertEquals("This is what it says...", p.getBody());
			//assertEquals(now,p.getCreated());
			assertEquals(null,p.getUpdated());
			System.out.println(p);
		}
		
	//Test Updated
		@Test
		public void testUpdated() {
			Post p = new Post("My Second Test Blog Post","This is what it says...","Tom Jones");
			System.out.println(p);
			p.setTitle("Edited my title");
			System.out.println(p);
		}
	
	//Get user list test
		@Test		
		public void testUserList() {
			User.getUserList().clear();
			ArrayList<User> ulTest = new ArrayList<User>();
			
			for (int i = 0; i < 100; i++) {
				User u = new User("TestUser" + i, "123456");
				ulTest.add(u);
			}	
				
			System.out.println(ulTest);
			System.out.println(User.getUserList());
			assertTrue("user lists do not match", User.getUserList().equals(ulTest));
		}
	

}
