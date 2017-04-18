// Huirong Huang - s3615907
package etb.monster;

import etb.util.Timer;

public class Monster0
{
	private final int MAX_SPEED_MONSTER = 4;

	private int x;
	private int y;
	private String direction;
	private int speed;

	public Monster0(int x, int y, String direction, int speed)
	{
		setX(x);
		setY(y);
		setDirection(direction);
		setSpeed(speed);
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public void setDirection(String direction)
	{
		this.direction = direction;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public String getDirection()
	{
		return direction;
	}

	public int getSpeed()
	{
		return speed;
	}

	public boolean move(String direction)
	{
		switch(direction)
		{
		case "north":
			setY(--y);
			break;
		case "south":
			setY(++y);
			break;
		case "west":
			setX(--x);
			break;
		case "east":
			setX(++x);
			break;
		}
		return true;
	}

	public boolean eatFood()
	{
		setSpeed(getSpeed() / 2);
		
		return true;
	}
	
	public boolean posioned()
	{
		Timer posionTime = new Timer(2);
		do {} while (!posionTime.timeUp());
		return true;
	}
	
	public boolean restoreSpeed()
	{
		setSpeed(getSpeed() * 2);
		return true;
	}
}
