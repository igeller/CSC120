import java.io.*;
import java.util.*;
import java.lang.*;

public class Clock //implements Comparable <Clock>
{
	//instance variables
	int combinedValue;
	private int value;

	
	
	
	//constructors
	public Clock(int sign, int day, int hour, int minute)
	{
		if(sign == 0)
			sign = 0;
		else if (sign > 0)
			sign = 1;
		else
			sign = -1;
		
		value = (Math.abs(minute) + Math.abs(hour * 60) + Math.abs(day * 24 * 60)) * sign;
		combinedValue = value;
	}//end clock construct
	
	public Clock(int value)
	{
		this.combinedValue = value;

	}//end clock contr
	
	
	
	//accessors
	public int getSign()
	{
		if(combinedValue == 0)
			return 0;
		else if (combinedValue > 0)
			return 1;
		else
			return -1;
	}//end getsign
	
	public int getDay()
	{
		return ((combinedValue / 60) / 24);
	}//end getDay
	
	public int getHour()
	{
		return (combinedValue/ 60) - (getDay() * 24);
	}//end getHour
	
	public int getMinute()
	{
		return (combinedValue - ((getDay() * 24* 60) + getHour()*60));
	}//end getMin
	
	
	
	//instance methods
	public int compareTo(Clock o)
	{

		return this.combinedValue - o.combinedValue;
	}//end compare
	
	public Clock plus(Clock o)
	{
		return new Clock(this.getSign(), getDay() + o.getDay(), getHour() + o.getHour(), getMinute()+ o.getMinute());
	}//end plus
	
	public Clock minus(Clock o)
	{
		return new Clock(this.getSign(), getDay() - o.getDay(), getHour() - o.getHour(), getMinute() - o.getMinute());		
	}//end minus
	
	public String toString()
	{
		String s;
		if(getDay() > 0)
			s = "+" + getDay() + " days, " + Math.abs(getHour()) + " hours, " + Math.abs(getMinute()) + " minutes";
		else 
			s = getDay() + " days, " + Math.abs(getHour()) + " hours, " + Math.abs(getMinute()) + " minutes";
		return s;
	}
	
	
	
	
	
	
	
}//end clock class
