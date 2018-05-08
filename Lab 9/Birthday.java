import java.util.*;
import java.lang.*;


public class Birthday
{
	public static void main(String [] args)
	{
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Enter the no. of people: ");
		int nPeople = reader.nextInt();
		
		System.out.print("Enter the no. of repetitions: ");
		int nReps = reader.nextInt();
		
		System.out.printf("Experiment 1%nProbablity if Hits: %.3f%n%n", experiment1(nPeople, nReps));
	}//end main
	
	
	
	public static double experiment1(int nPeople, int nReps)
	{
		double hitRate = 0;
		int [] oneTArray;
		boolean hasHitResult;
		for(int i = 1; i <= nReps; i++)
		{
			oneTArray = oneTrial(nPeople);
			hasHitResult = hasAHit(oneTArray);
			
			if(hasHitResult == true)
				hitRate++;
		}
		
		hitRate /= nReps;
		return hitRate;
		
	}//end experiment1
	
	
	
	public static int[] oneTrial(int nPeople)
	{
		int [] theCounts = new int[365];
		int index = 0;
		
		for(int i = 1; i <= nPeople; i++)
		{
			index = (int)(Math.random()*365);
			theCounts[index] += 1;
		} 
		return theCounts;
	}//end oneTrial
	
	
	
	public static boolean hasAHit(int [] oneTArray)
	{
		for(int i = 0; i <= oneTArray.length-1; i++)
		{
			if (oneTArray[i] >= 2)
				return true;
		}
		
		return false;
	}//end hasAHit
}//end class
