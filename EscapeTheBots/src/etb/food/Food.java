package etb.food;

public class Food 
{	
	private int x;
	private int y;
	
	public Food(int x, int y)
	{
		setX(x);
		setY(y);
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
	
	
}
