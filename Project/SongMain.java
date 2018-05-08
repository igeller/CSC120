import java.util.*;
import java.io.*;
import java.util.*;

public class SongMain
{
	public static void main(String [] args)
	{
		Scanner reader = new Scanner(System.in);
		int choice; 
		//Song [] sl = new Song [3];
		SongCollection sc = new SongCollection(new Song [0]);
		File f4, f5;
		
		do{
			System.out.print("========Select Action========\n" +
						"0. Quit\n" +
						"1. Get Collection Size\n" +
						"2. Search for Title\n" +
						"3. Search for Artist\n" +
						"4. Add from File\n" +
						"5. Save to File\n" +
						"6. Add One Song\n" +
						"7. Remove One Song\n" +
						"8. Show\n" +
						"Enter choice: ");
			switch(choice = Integer.parseInt(reader.nextLine())){
				case 1: System.out.println("***\n***Size = " + sc.size()); 
					break;
				case 2: System.out.print("Enter search key: ");
					sc.searchByTitle(reader.nextLine());
					break;
				case 3: System.out.print("Enter search key: ");
					sc.searchByArtist(reader.nextLine());
					break;
				case 4: System.out.print("Enter file Name: ");
					f4 = new File (reader.nextLine());
					sc.addFromFile(f4);
					break;
				case 5: System.out.print("Enter file name: ");
					f5 = new File(reader.nextLine());
					sc.writeToFile(f5);
					break;
				case 6: System.out.print("Enter title: ");
					String title = reader.nextLine();
					System.out.print("Enter artist: ");
					String artist = reader.nextLine();
					sc.addOneSong(title, artist);
					break;
				case 7: System.out.print("Enter position: ");
					sc.delete(Integer.parseInt(reader.nextLine()));
					break;
				case 8: System.out.print("Enter start position: ");
					int start = Integer.parseInt(reader.nextLine());
					System.out.print("Enter end position: ");
					int end = Integer.parseInt(reader.nextLine());
					sc.show(start, end);
					break;
			}
			
		}while(choice != 0); 
	}//end main
}//end class
