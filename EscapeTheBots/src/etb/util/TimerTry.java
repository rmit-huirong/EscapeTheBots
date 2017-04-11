package etb.util;

import java.util.Scanner;

public class TimerTry {

	public static void main(String[] args)
	{
	long  timea = System.currentTimeMillis();
	String st;
	long time1;
	long time2;
	System.out.println("Timea: " + timea);
	time1 = timea / 1000 + 5;
	time2 = timea / 1000 + 10;
	System.out.println("Time1: " + time1);
	System.out.println("Time2: " + time2);
	
	Scanner input = new Scanner(System.in);
	st = input.next();
	long  timeb = System.currentTimeMillis() / 1000;
	System.out.println("Timeb: " + timeb);
	
	if (timeb - time1 < 0)
	{
		System.out.println("Less than 5s");
	}
	else if (timeb - time2 < 0)
	{
		System.out.println("Less than 10s");
	}
	}
}
