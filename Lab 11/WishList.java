import java.util.*;
import java.io.*;
import java.lang.*;


public class WishList
{
	public static void main(String [] args) throws IOException
	{
		File f = new File("wishListMaster.txt");
		
		Scanner reader = new Scanner(System.in);
		Scanner fRead = new Scanner(f);
		

		String [][] data = new String [fRead.nextInt()][];
		String [] item = new String[3];
		
		data = read(f);
		
		int selection = 1; 
		
		while(selection != 4)
		{
			System.out.print("Which action should I perform?\n" +
					"1. Add\n" +
					"2. Remove\n" +
					"3. View the items\n" +
					"4. Quit\n" +
					"Enter your choice: ");
			selection = Integer.parseInt(reader.nextLine());
			if(selection == 1)
			{
				System.out.println("Enter type, name, price with \\t in between");
				item = reader.nextLine().split("\t");
				data = add(data, item);
				
			}
			
			else if(selection == 2)
			{
				System.out.print("Enter index: ");
				int index = Integer.parseInt(reader.nextLine());
				data = remove(data, index);
			}
			
			else if(selection == 3)
			{
				view(data);
			}
		}
		
		File newF = new File("wishListMasterNew.txt");
		write(newF, data);

	}//end main
	
	
	
	public static String[][] read( File f ) throws FileNotFoundException
	{
		Scanner fread = new Scanner(f);
		int n = Integer.parseInt(fread.nextLine());
		String [][] data = new String [n][3];
		String [] item = new String [3];
		
		
		while(fread.hasNextLine())
		{
			for(int i = 0; i < data.length; i++)
			{
				item = (fread.nextLine()).split("\t");
				data[i] = item;
			}
		}
		return data;
		
	}//end read
	
	
	
	
  	public static String[][] add( String[][] data, String[] item )
  	{
  		String [][] nData = Arrays.copyOf(data, data.length+1);
  		nData[data.length]= item;
  		return nData;
  	}//end add
  	
  	
  	
  	
  	public static String[][] remove( String[][] data, int index )
  	{
  		
  		String [][] nData = new String[data.length-1][];
  		
  		for(int i = 0; i < index; i++)
  			nData[i] = data[i];
  		for(int j = index; j < nData.length; j++)
  			nData[j] = data[j+1];
  			
  		return nData;
  	}//end remove
  	
  	
  	
  	public static void view(String [][] data)
	{
		System.out.println( "total=" + data.length );
   		for ( int i = 0; i < data.length; i ++ )
   		{
     			System.out.printf( "%03d:%s\t%s\t%s%n", i, data[ i ][ 0 ], data[ i ][ 1 ], data[ i ][ 2 ] );
    		}
	}//end view
  	
  	
  	
  	
  	public static void write( File f, String[][] data ) throws FileNotFoundException
  	{
  		PrintStream writer = new PrintStream(f);
  		for ( int i = 0; i < data.length; i ++ )
   		{
     			writer.printf( "%s\t%s\t%s%n", data[ i ][ 0 ], data[ i ][ 1 ], data[ i ][ 2 ] );
    		}
    		System.out.println("...Writting to file: " + f.getName());
  	}//end write
  	
}//end class
