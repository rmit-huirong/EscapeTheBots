package etb.user;


import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String username;
	private static char[] password;
	private static int[] scores = new int[2]; // scores[0] = win scores[1] = lose;

	public User(String username, char[] password) {
		this.username = username;
		this.password = password;

	}

	public static String getUsername() {
		return username;
	}
	
	public static void setScores(int[] tempScores){
		scores[0] += tempScores[0];
		scores[1] += tempScores[1];
	}
	
	public static void resetScores(){
		scores[0] = 0;
		scores[1] = 0;
	}
	
	public static String getWinScore(){
 		return scores[0]+"";
	}
	
	public static String getLoseScore(){
		return scores[1]+"";
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
	
	public boolean isPasswordCorrect(char[] input) {
	    boolean isCorrect = true;

	    if (input.length != this.password.length) {
	        isCorrect = false;
	    } else {
	        isCorrect = Arrays.equals (input, this.password);
	    }
	    return isCorrect;
	}
	
	 private void writeObject(java.io.ObjectOutputStream stream)
	            throws IOException {
	        stream.writeObject(username);
	        stream.writeObject(password);
	        stream.writeObject(scores);
	    }
	 
	 private void readObject(java.io.ObjectInputStream stream)
	            throws IOException, ClassNotFoundException {
	        username = (String) stream.readObject();
	        password = (char[]) stream.readObject();
	        scores = (int[]) stream.readObject();
	    }


}