package etb.user;

import java.util.Scanner;

public class Gamer extends User{

	public Gamer(String username, String password) {
		super(username, password);
		
	}

	public boolean register() {

		Scanner input1 = new Scanner(System.in);		
		super.setUsername(input1.nextLine()); 
		Scanner input2 = new Scanner(System.in);
		super.setPassword(input2.nextLine());
		
		for(int i = 0; i < UserSystem.users.size(); i++)
			if(UserSystem.users.get(i).getUsername().compareTo(getUsername()) == 0 ){
			return false;
			} else {
				UserSystem.addGamer();
			}
			
			return true;
	}
}