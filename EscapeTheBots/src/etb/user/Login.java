package etb.user;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
	
	public Boolean loginAuthorisation() {
		
		Scanner input1 = new Scanner(System.in);		
		String username = input1.nextLine();
		Scanner input2 = new Scanner(System.in);
		String password = input2.nextLine();
		
		ArrayList<User> users = new ArrayList<User>();		
		
			/**if(users.getUsername().compareTo(username) == 0 && (users.getPassword().compareTo(password) == 0) 
			{
			return true;
			
			}else{
				
			return false;
			}	**/
		
		if(username.equals(users) && (password.equals(users))) {
			return true;
		} else{
			return false;
		}
	}		
}
