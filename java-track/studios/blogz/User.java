package blogz;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class User extends Entity {
	//1. Create a User class with properties to represent username and hashed password.
	//4. Add a static property of type List<User> to hold the list of all users 
	private String username;
	private String password;
	private static List<User> userList = new ArrayList<User>();
	private static final String PATTERN = "[a-zA-Z][a-zA-Z0-9_-]{4,11}";

	
	//1. The constructor should take in a password in plain text and call a 
	//private static method hashPassword to generate the hashed password before setting 
	//the appropriate instance property. 
	
	public User(String un, String pw) {
		super();
		password = User.hashPassword(pw);
		
		if (isValidUserName(un, PATTERN)) {
			username = un;
		}
		
		userList.add(this);
	}
	
	//getters
	public String getUserName() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	//methods
	public static String hashPassword(String pw) {
		return pw;
	}
	
	//2. Write a method to verify a password against its hash
	public boolean isValidPassword(String pw) {		
		return true;
	}
	
	//3. write a static method isValidUsername that returns a 
	//boolean signifying whether or not the given string is valid.
	//An appropriate exception should be thrown if the username is not valid. 
	public static boolean isValidUserName(String un, String pattern) {		
	
		boolean b = un.matches(pattern);
		
		if (!b) {
			throw new PatternSyntaxException("Invalid username", PATTERN, -1);
		}
		
		return b;
	}

	//4. along with a method to return this list.
	public static List<User> getUserList() {
		return userList;
	}
	
	public String toString() {
		return this.username + ", " + this.password + ", ID: " + this.getUid();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//User.isValidUserName("abc1de",PATTERN);
		User u1 = new User("joe123","mypw456");
		System.out.println(u1);
		Post p1 = new Post("My Title1", "My Body1","author1");
		System.out.println(p1);
		User u2 = new User("fred11","mypw456");
		System.out.println(u2);
		User u3 = new User("jill123","mypw456");
		System.out.println(u3);
	}

}
