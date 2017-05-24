package etb.user;


import java.util.Arrays;
import java.util.Scanner;

public class User {
	private static String username;
	private static char[] password;

	public User(String username, char[] password) {
		this.username = username;
		this.password = password;

	}

	public static String getUsername() {
		return username;
	}

	public static char[] getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}
	
	public static boolean isPasswordCorrect(char[] input) {
	    boolean isCorrect = true;

	    if (input.length != password.length) {
	        isCorrect = false;
	    } else {
	        isCorrect = Arrays.equals (input, password);
	    }
	    return isCorrect;
	}


}