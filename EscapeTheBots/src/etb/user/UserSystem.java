package etb.user;

import java.util.*;

import javax.swing.JFrame;

import etb.game.Game;

public class UserSystem<username, password> extends User{
	static HashMap<username, password> users = new HashMap<username, password>(); 

public UserSystem(String username, String password)
{		
	super(username,password);
}

 	public boolean register()
 	{
 		Map<? extends username, ? extends password> gamer = (Map<? extends username, ? extends password>) new Gamer(null, null);
 		((Gamer) gamer).register();
 		users.putAll(gamer);
 		return true;
 	}
 	
 	public boolean login() //implement gui
 	{

 		User user = new User(null, null);
 			user.login();
 			
 			for(int i = 0; i < users.size(); i++)
			{
 				if(((User) users.get(i)).getUsername().compareTo(user.getUsername()) == 0 && ((User) users.get(i)).getPassword().compareTo(user.getPassword()) == 0){
 					Game game = new Game();
 		 			game.frame.setResizable(false);
 		 			game.frame.add(game);
 		 			game.frame.pack();
 		 			game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		 			game.frame.setLocationRelativeTo(null);
 		 			game.frame.setVisible(true);

 		 			game.start();
 					return true;				
		} else{
			
				return false;
			}
		}			
		return false;
 	}
}