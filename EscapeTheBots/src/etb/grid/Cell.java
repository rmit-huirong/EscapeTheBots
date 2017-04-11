package etb.grid;

public class Cell {
	
	private int x, y, width, height;
	private int CELL_HEIGHT = 1;
	private int CELL_WIDTH = 1;

	
	public Cell(int x, int y, int width, int height)
	{
		
		setX(x);
		setY(y);
		setHeight(CELL_HEIGHT);
		setWidth(CELL_WIDTH);
		
		
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int setHeight(int height)
	{
		return this.height = height;
		
	}
	
	public int setWidth(int width)
	{
		return this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}


}
