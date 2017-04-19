package etb.game;

/* 
 * Author - Huirong Huang - s3615907
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import etb.food.Food;
import etb.graphics.Level;
import etb.graphics.Screen;
import etb.graphics.Spritesheet;
import etb.strategy.Strategy;

public class Game extends Canvas implements Runnable, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 4 * 3;
	public static final int SCALE = 2;
	private static final String TITLE = "Escape the Bots!";
	public int countDown;

	private Thread thread;
	private JFrame frame;

	private boolean isRunning = false;

	
	
	public static Level level;
	public static Spritesheet spritesheet;

	private int foodCount;

	public Game() {
		Dimension dimension = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(dimension);
		setMaximumSize(dimension);
		setMinimumSize(dimension);
		addKeyListener(this);
		addMouseListener(this);
		frame = new JFrame(TITLE);
		level = new Level("/map/map_1.png");
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
		countDown = 99;
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
				frame.setTitle(TITLE + " | FPS: " + fps + " Countdown: " + countDown);
				if (countDown == 0) {
					System.exit(1);
				}
				fps = 0;
				timer += 1000;
				countDown--;
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
	/*
	 * Author - Huirong Huang - s3615907
	 */

	/*
	 * Author - Navod Bopitiya - s3617221
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			level.player.setUp(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			level.player.setDown(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			level.player.setRight(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			level.player.setLeft(true);
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			level.player.setUp(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			level.player.setDown(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			level.player.setRight(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			level.player.setLeft(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Point point = level.player.getLocation();
			Food testFoodObject = new Food(point);

			if (foodCount < 2) {
				if (testFoodObject.canPlace()) {
					level.food.add(testFoodObject);
					foodCount++;
				}
			}
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println(x + "     " + y);
		Food testFoodObject = new Food(x, y);
		if (foodCount < 2) {
			if (testFoodObject.canPlace()) {
				level.food.add(testFoodObject);
				foodCount++;
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
	/*
	 * Author - Navod Bopitiya - s3617221
	 */
}
