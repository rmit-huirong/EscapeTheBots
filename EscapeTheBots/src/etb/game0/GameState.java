package etb.game0;

import java.awt.Graphics;

import etb.game0.Game0;
import etb.game0.State;
import etb.grid.World;

public class GameState extends State {
	
	private World world;
	
	public GameState(Game0 game){
		super(game);
		world = new World("res/world2.txt");
	}

	public void tick() {
		// TODO Auto-generated method stub
		world.tick();
		
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		world.render(g);
		//g.drawImage(Assets.block, 0, 0, null);
		
	}

}