package etb.game1;

import java.awt.Graphics;

public abstract class State {
	
	private static State currentState = null;
	
	public State(Game game) {
		// TODO Auto-generated constructor stub
	
	}

	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	
	//CLASS

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
