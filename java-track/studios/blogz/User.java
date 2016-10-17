package blogz;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class User {
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
	private static String hashPassword(String pw) {
		return pw;
	}
	
	//2. Write a method to verify a password against its hash
	private static boolean isValidPassword(String pw) {		
		return true;
	}
	
	//3. write a static method isValidUsername that returns a 
	//boolean signifying whether or not the given string is valid.
	//An appropriate exception should be thrown if the username is not valid. 
	private static boolean isValidUserName(String un, String regex) {		
		
		boolean b = Pattern.matches(un, regex);
		
//		 Pattern p = Pattern.compile("a*b");
//		 Matcher m = p.matcher("aaaaab");
//		 boolean b = m.matches();

		System.out.println(b);
//		if (!b) {
//			throw new PatternSyntaxException("Invalid username", PATTERN, -1);
//		}
		return b;
	}

	//4. along with a method to return this list.
	private List<User> getUserList() {
		return userList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
