// Huirong Huang - s3615907
package util;

public class Timer {

	private long  time = System.currentTimeMillis() / 1000;
	private long timeDue;
	public Timer(int duration)
	{
		this.timeDue = this.time + duration;
	}
		
	public boolean timeUp()
	{
		long time = System.currentTimeMillis() / 1000;
		if (time - this.timeDue >= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}