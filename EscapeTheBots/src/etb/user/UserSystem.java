package etb.user;

import java.util.ArrayList;

import javax.swing.JFrame;

import etb.game.Game;

public class UserSystem {
	static ArrayList<User> users = new ArrayList<User>();
	
public UserSystem()
{
		//for(int i = 0; i < users.size(); i++)
//	{
		//if(users.get(i).getUsername().compareTo(user.getUsername()) == 0 && users.get(i).getPassword().compareTo(user.getPassword()) == 0){
		
	
}

 	public static boolean addGamer()
 	{
 		User gamer = new Gamer(null, null);
 		((Gamer) gamer).register();
 		users.add(gamer);
 		return true;
 	}
 	
 	public boolean login()
 	{

 		User user = new User(null, null);
 			user.login();
 			Game game = new Game();
 			game.frame.setResizable(false);
 			game.frame.add(game);
 			game.frame.pack();
 			game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 			game.frame.setLocationRelativeTo(null);
 			game.frame.setVisible(true);

 			game.start();
				return true;
				
			//} else{
			//	return false;
			//}
		//}			
		
 	}
}