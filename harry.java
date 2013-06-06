import java.util.*;

public class harry{
	public static void main(String[] args)
	{
		System.out.println("harry");
			
		// Define Standard Array for 1st Dimension
		ArrayList<String> myarray = new ArrayList<String>();		
		// Put values in new array
		myarray.add("hey1");
		myarray.add("hey2");
		myarray.add("hey3");

		// Define Standard Array for 2nd Dimension
		ArrayList<String> myarray2 = new ArrayList<String>();		
		// Put values in new array
		myarray2.add("heyhey1");
		myarray2.add("heyhey2");
		myarray2.add("heyhey3");
			
			
			
		// Craete MultiDimensional Array raedy to add standard dimensions
		System.out.println("Multidiemsnional ArrayList");
		System.out.println("");
		
		ArrayList<ArrayList<String>> multi = new ArrayList<ArrayList<String>>();		
		
		// Add standard array into a new dimension of the multidimensional array
		// Add 1st Dimension
		multi.add(myarray);
		// Add 2nd Dimension
		multi.add(myarray2);
		
		//System.out.println("Size multi: "+multi.size());
		//System.out.println("Size standard: "+myarray.size());
		
		for(int y = 0; y < multi.size(); y++)
		{
			System.out.println("Dimension: "+y);
			for(int z = 0; z < myarray.size(); z++)
			{
				System.out.println(multi.get(y).get(z));
			}
		}
		
		
	}

}