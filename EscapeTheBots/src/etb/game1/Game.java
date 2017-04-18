package etb.game1;

import etb.display.Display;
import etb.grid.Assets;
import etb.grid.Tile;
import etb.grid.World;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

	private Display display;
	public int width, height;
	public String title;
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	
	
	public Game(String title, int width, int height){
		
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	
	private void init(){
	
		display = new Display(title, width, height);
		Assets.init();

		gameState = new GameState(null);
		State.setState(gameState);
		
	}
	

	
	private void tick(){
		
		if(State.getState() != null)
			State.getState().tick();
		
		
	}
	
	private void render(){
		
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
			
		}
		
		g = bs.getDrawGraphics();
		
		//Clear Screen
		g.clearRect(0, 0, width, height);
		
		//Draw Here!
		
		if(State.getState() != null)
			State.getState().tick();
		
		//g.drawImage(Assets.grass, x, 10, null);
		//Tile.tiles[0].render(g, 0, 0);
		//Tile.tiles[1].render(g, 0, 50);
		//Tile.tiles[0].render(g, 0, 100);
		World.render(g);
		//g.drawImage(Assets.block, 70, 70, null);
		
		
		//End Drawing Here!
		
		bs.show();
		g.dispose();
		
		
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
			tick();
			render();
			ticks++;
			delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public synchronized void start(){
		
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}