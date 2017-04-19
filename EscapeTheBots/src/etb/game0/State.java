package etb.game0;

import java.awt.Graphics;

import etb.game0.Game0;
import etb.game0.State;

public abstract class State {
	
	private static State currentState = null;
	
	public State(Game0 game) {
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
