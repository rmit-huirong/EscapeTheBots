package etb.game1;

import java.awt.Graphics;

import etb.game1.Game;
import etb.game1.State;
import etb.grid.World;

public class GameState extends State {
	
	private World world;
	
	public GameState(Game game){
		super(game);
		world = new World("resource/world/world.txt");
	}

	public void tick() {
		// TODO Auto-generated method stub
		world.tick();
		
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		world.render(g);
		
		
	}

}

