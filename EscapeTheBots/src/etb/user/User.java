package etb.user;


import java.util.Scanner;

public class User {
	String username;
	String password;

	public User(String username, String password) {
		this.username = username;
		this.password = password;

	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean login() {

		Scanner input1 = new Scanner(System.in);
		username = input1.nextLine();
		Scanner input2 = new Scanner(System.in);
		password = input2.nextLine();
		return true;

	}

}