import java.io.*;
import java.util.*;


public class myjarvis{
	public static void main(String[] args)
	{

		// vars
		String myinput = "";
		BufferedReader myread = new BufferedReader (new InputStreamReader(System.in));
		File myfile = new File("jarvismem.txt");
		myjarvis myobj = new myjarvis();
		ArrayList<String> mylist = new ArrayList<String>();




		// get sysdate
		Date d = new Date();
		String sysdate = d.toString();
		String currTime24 = sysdate.substring(11,16);
		String currTimeSTD = sysdate.substring(11,13);
		int foo = Integer.parseInt(currTimeSTD);
		if(foo > 12)
		{
			foo = foo - 12;
		};
		currTimeSTD = foo + ":" + sysdate.substring(14,16);
		if(foo < 10)
		{
			currTimeSTD = "0"+currTimeSTD;
		};
		//System.out.println("24 clock time is :"+currTime24);
		//System.out.println("Standard clock time is : "+currTimeSTD);



		
		// Greeting
		if(Integer.parseInt(sysdate.substring(11,13)) < 13)
		{
			System.out.println("Good morning sir, how are you?");		
		}
		else
		{
			if(Integer.parseInt(sysdate.substring(11,13)) < 17)
			{
				System.out.println("Good afternoon sir, how are you?");		
			}
			else
			{
				if(Integer.parseInt(sysdate.substring(11,13)) < 23)
				{	
					System.out.println("Good evening sir, how are you?");						
				}
				else
				{
					System.out.println("Working late tonight sir, what can i do?");	
				}
			}
		}




		// infinite loop
		int x = 0;
		while (x != 99)
		{

			// take input
			try
			{
				myinput = myread.readLine();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}




			// greeting response
			if(myinput.equals("fine"))
			{
				System.out.println("I am glad to here that sir!!!");
			}
			else
			{
				System.out.println("ok, sir!");
			}





			// check remember
			boolean retval = myinput.contains("remember");			
			if(retval)
			{
			// split REMEMBER DESC TIME
			String checkRemember ="";
			//System.out.println(myinput.length());
			if(myinput.length() > 7)
			{		
				checkRemember = myinput.substring(0,8);
			}

			//File myfile = new File("jarvismem.txt");
			if(checkRemember.equals("remember"))
			{
				// store the actual reminder note minus the reminder text
				String actualNote = myinput.substring(9,myinput.length());
				// load array from file				
				mylist = myobj.loadArray("jarvismem.txt");
				// add actualNote to array
				mylist.add(actualNote);
				// load file from array
				myobj.loadFile(mylist, "jarvismem.txt");
			}
			}


				
			// List - list what is is the mem list
			retval = myinput.contains("what have we got jarvis");
			if(retval)
			{
				if(myfile.exists())
				{			
				
					try
					{
						BufferedReader in = new BufferedReader(new FileReader(myfile));
						String line;
						int numLines = 0;
						int lineLength = 0;
						while((line = in.readLine()) != null)
						{
							numLines++;
							lineLength = line.length();
    						System.out.println(line);
						}
						in.close();
						if(lineLength == 0 && numLines == 1)
						{
							System.out.println("no list yet, sir - would you like me to remember something for later?");	
						}	
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}	



			// Delete whole of list and start again
			retval = myinput.contains("new list");	
			if(retval)
			{
				try
				{
					if(myfile.exists())
					{
						//
						myjarvis myobjdel = new myjarvis();
						ArrayList<String> mylistdel = new ArrayList<String>();
						// load new file from an empty array to delete the file contents consistently
						myobjdel.loadFile(mylistdel, "jarvismem.txt");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}			


			// removal of a particular item from the list
			retval = myinput.contains("jarvis remove");
			if(retval)
			{
				if(myfile.exists())
				{			
				
					try
					{
						String checkedInput = myinput.substring(14,myinput.length());

						// load array from file				
						mylist = myobj.loadArray("jarvismem.txt");
						// add actualNote to array
						mylist.remove(checkedInput);
						// load file from array
						System.out.println("sir, the new list is: ");
						myobj.loadFile(mylist, "jarvismem.txt");
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}


			// check if a reminder is required at this time
			// to be worked on
			if(myfile.exists())
			{
			try
			{
				FileReader fr = new FileReader(myfile);
				BufferedReader br = new BufferedReader(fr);

				// check reminders in file
				String aline = br.readLine();
				//System.out.println("LINE: "+aline);
			}
			catch(Exception f)
			{
				f.printStackTrace();
			}
			}


			// bye
			if(myinput.equals("bye"))
			{
				x = 99;
			}

		}

	}



	// Method loads a file into an array and returns the array
	ArrayList<String> loadArray(String thefile)
	{
		//System.out.println("Load array");

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
		//System.out.println("Load file");

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
