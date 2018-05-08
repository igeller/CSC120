import java.util.*;

public class Election
{
	public static void main(String [] args)
	{
		String [] names = new String[0];
		int [] counts = new int[0];
		Scanner reader = new Scanner(System.in);
		
		System.out.println("###########################################\n"
				 + "# Enter the votes, one vote per line.     #\n"
				 + "# End with either CTRL-D or an empty line.#\n"
				 + "###########################################");
		
		String candidate = "";
		String input = "\n";
		int index = 0;
		int val = 0;
		
		while(reader.hasNextLine())
		{
			candidate = reader.nextLine();			
			if(candidate.equals(""))
				break;
			index = find(names, candidate);

			if (index == -1)
			{
				names = addName(names, candidate);
				counts = addNewCount(counts);
			}
			else
			{
				val = counts[index];
				val += 1;
				counts[index] = val;
				
			}
		}
		findWinner(names, counts);
	}//end main
	
	
	
	public static int find(String [] names, String candidate)
	{
		int result=-1;
		for(int i = 0; i < names.length; i++)
		{
			if(candidate.equals(names[i]))
				result = i;	
		}
		
		return result;
	}//end find
	
	
	
	public static String [] addName(String [] names, String candidate)
	{
		
		int length = names.length;
		String [] newList = new String[length+1];
		
		for(int i = 0; i < newList.length; i++)
		{
			if (i == newList.length-1)
				newList[i] = candidate;
			else
				newList[i] = names[i];
		}
		
		
		return newList;
	}//end addName
	
	
	
	public static int [] addNewCount(int [] counts)
	{
		int [] newCounts = new int [counts.length+1];
		
		for(int i = 0; i < newCounts.length; i++)
		{
			if (i == newCounts.length-1)
				newCounts[i] = 1;
			else
				newCounts[i] = counts[i];
		}
		return newCounts;
	}//end addNewCount
	
	
	
	public static void findWinner(String [] names, int [] counts)
	{
		int maxCount = 0;
		int theWinner = 0;
		for(int i = 0; i < names.length; i++)
		{
			System.out.println(names[i] + " received " + counts[i] + " votes.");
			if(maxCount < counts[i])
			{
				maxCount = counts[i];
				theWinner = i;
			}
			
		} 
		System.out.println("--------\n" + "The winner is " + names[theWinner] +"!");

		
	}//end findWinner
}//end class

