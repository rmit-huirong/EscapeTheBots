// Huirong Huang - s3615907
package etb.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import etb.monster.Monster;
import graphics.Screen;
import graphics.Spritesheet;
import graphics.Level;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 4 * 3;
	public static final int SCALE = 2;
	private static final String TITLE = "Escape the Bots!";

	private Thread thread;
	private JFrame frame;

	private boolean isRunning = false;

	private Screen screen;

	public static Level level;
	public static Spritesheet spritesheet;

	public Game() {
		Dimension dimension = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(dimension);
		setMaximumSize(dimension);
		setMinimumSize(dimension);

		frame = new JFrame(TITLE);
		level = new Level("/map/map_rmit2017.png");
		spritesheet = new Spritesheet("/sprites/spritesheet.png");
	}

	public synchronized void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		requestFocus();

		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double targetTick = 60.0;
		double ns = 1000000000.0 / targetTick;
		double delta = 0;
		int fps = 0;

		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				tick();
				render();
				fps++;
				delta--;
			}

			if (System.currentTimeMillis() - timer >= 1000) {
				System.out.println(fps);
				fps = 0;
				timer += 1000;
			}
		}
	}

	public void tick() {
		level.tick();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		level.render(g);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}
}
