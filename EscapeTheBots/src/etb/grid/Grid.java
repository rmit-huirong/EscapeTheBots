package etb.grid;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Grid {
	
	private static int x, y, width, height;
	private static final int GRID_HEIGHT = 100;
	private static final int GRID_WIDTH = 100;
	
	private static Grid[][] grid  = new Grid[x][y];
	
	
	public Grid(int Grid[][])
	{
		
		setGrid(grid);
		
	}
	
	public Grid(int height, int width)
	{
		setX(x);
		setY(y);
		setHeight(GRID_HEIGHT);
		setWidth(GRID_WIDTH);
		
	}

	
	public static Grid[][] getGrid() {
		return grid;
	}

	public static void setGrid(Grid[][] grid) {
		Grid.grid = grid;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		Grid.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		Grid.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		Grid.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		Grid.height = height;
	}
	
	
}
