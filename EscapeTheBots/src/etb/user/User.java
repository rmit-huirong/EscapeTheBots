package etb.user;


import java.util.Scanner;

public class User {
	static String username;
	static String password;

	public User(String username, String password) {
		this.username = username;
		this.password = password;

	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean login() { //make it a void method

		Scanner input1 = new Scanner(System.in);
		username = input1.nextLine();
		Scanner input2 = new Scanner(System.in);
		password = input2.nextLine();
		return true;

	}

}