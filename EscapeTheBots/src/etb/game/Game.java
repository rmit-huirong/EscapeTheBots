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
import javax.swing.JOptionPane;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import etb.food.Food;
import etb.graphics.Level;
import etb.graphics.Spritesheet;
import etb.monster.Monster;
import etb.player.Player;

public class Game extends Canvas implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 4 * 3;
	public static final int SCALE = 2;
	private static final String TITLE = "Escape the Bots!";
	public static int countDown;

	public static int getCountDown() {
		return countDown;
	}

	public static void setCountDown(int countDown) {
		Game.countDown = countDown;
	}

	public static int win = 0;
	public static int lose = 0;

	private Thread thread;
	public JFrame frame;

	private boolean isRunning = false;

	public static Level level;
	public static Spritesheet spritesheet;
	public static int round = 1;
	private static boolean paused = false;

	public static boolean isPaused() {
		return paused;
	}

	public static void setPaused(boolean paused) {
		Game.paused = paused;
	}

	public Game() {
		Dimension dimension = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(dimension);
		setMaximumSize(dimension);
		setMinimumSize(dimension);
		addKeyListener(this);
		frame = new JFrame(TITLE);
		level = new Level("/map/map_final.png");
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
		countDown = 100;
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
				if (paused) {
					try {
						thread.sleep(1000 / 60);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					tick();
					render();

				}
				fps++;
				delta--;

			}

			if (System.currentTimeMillis() - timer >= 1000) {
				frame.setTitle(TITLE + " | Countdown: " + countDown + " | Round " + round + " | " + " ( WIN " + win + " / LOSE " + lose + " )");
				if (!paused) {
					if (countDown == 0) {
						round++;
						win++;
						countDown = 100;
					}
					fps = 0;

					countDown--;
				}
				timer += 1000;
			}
		}
		stop();
	}

	public void tick() {
		level.tick();
		for (int i = 0; i < level.monsters.size(); i++) {
			Monster monster = level.monsters.get(i);
			if (monster.intersects(level.player)) {
				round++;
				lose++;
				setCountDown(100);
				level.player = new Player(0, 0);
				level = new Level("/map/map_final.png");
			}

		}
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
		if (e.getKeyCode() == KeyEvent.VK_P) {
			paused = true;
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_R) {
			paused = false;
			return;
		}
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
		}if (e.getKeyCode() == KeyEvent.VK_Q) {
			System.exit(0);
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
			level.player.dropFood(level);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	/*
	 * Author - Navod Bopitiya - s3617221
	 */
}
