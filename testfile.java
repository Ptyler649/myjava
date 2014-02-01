import java.io.*;
import java.util.*;

public class testfile{
	public static void main(String[] args)
	{
		testfile mytest = new testfile();


		// Loads the array mylist from the file jarvismem.txt
		ArrayList<String> mylist = new ArrayList<String>();
		mylist = mytest.loadArray("jarvismem.txt");

		// Loads the array mylist into the file jarvismem.txt
		mytest.loadFile(mylist, "jarvismem.txt");
	}



	// Method loads a file into an array and returns the array
	ArrayList<String> loadArray(String thefile)
	{
		System.out.println("Load array");

		ArrayList<String> myarray = new ArrayList<String>();

		try
		{
			BufferedReader an = new BufferedReader(new FileReader(thefile));
			String line;

			while((line = an.readLine()) != null)
			{	
    			myarray.add(line);    						
			}
			an.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();

		};

		return myarray;

	}


	// Method Loads an array into a file
	void loadFile(ArrayList<String> myarray, String thefile)
	{
		System.out.println("Load file");

		File myfile = new File(thefile);
		try
		{
			myfile.createNewFile();
			BufferedWriter output = new BufferedWriter(new FileWriter(myfile));

			for(int i = 0; i < myarray.size(); i++)
			{
				System.out.println(myarray.get(i));
				output.write(myarray.get(i));

				if(i+1 < myarray.size())
					output.newLine();
			};
			output.newLine();
			output.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		};

	}


	// Method to remove an item from the arraylist and return the modified array
	// aListColors.remove("blue");  where aListColor is the arrayList





}