import java.io.*;
import java.util.*;


public class myjarvis{
	public static void main(String[] args)
	{

		// vars
		String myinput = "";
		BufferedReader myread = new BufferedReader (new InputStreamReader(System.in));
		File myfile = new File("jarvismem.txt");


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
			System.out.println("Good afternoon sir, how are you?");		
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
				// store a reminder
				String actualNote = myinput.substring(9,myinput.length());
				try
				{
					myfile.createNewFile();
					BufferedWriter output = new BufferedWriter(new FileWriter(myfile, true));
					output.write(actualNote);
					output.newLine();
					output.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
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
						while((line = in.readLine()) != null)
						{
    						System.out.println(line);
						}
						in.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			
				else
				{
					System.out.println("no list yet, sir - would you like to remember something for later?");
				}
			}	



			// start a new list by deleting the old list
			retval = myinput.contains("new list");	
			//System.out.println(retval);

			if(retval)
			{
				try
				{
					if(myfile.exists())
					{
						//System.out.println("Delete the file");
						System.gc();
						myfile.delete();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}			


			// removal of a particular item from the list
			// jarvis remove <variable> from the list
			retval = myinput.contains("jarvis remove");
			if(retval)
			{
				//System.out.println("Remove: "+myinput.length());
				//System.out.println(myinput.substring(14,myinput.length()));

				if(myfile.exists())
				{			
				
					try
					{
						ArrayList<String> mylist = new ArrayList<String>();
						String checkedInput = myinput.substring(14,myinput.length());
						BufferedReader an = new BufferedReader(new FileReader(myfile));
						String line;
						while((line = an.readLine()) != null)
						{
    						
    						if(checkedInput.equals(line))
    						{
    							System.out.println("Ok Sir, I have removed:"+checkedInput);
    						}
    						else
    						{
    							mylist.add(line);	
    						}
						}

						
						// remove the old list in preperation for the amended list
						try
						{
							if(myfile.exists())
							{
								//System.out.println("Delete the file");
								System.gc();
								myfile.delete();
							}
						}

						catch(Exception e)
						{
							e.printStackTrace();
						}


						// output array creating the new file - the matched value above					

						// create the new amended file

						System.out.println("sir, the new list is: ");
						//String actualNote = myinput.substring(9,myinput.length());
						try
						{
							myfile.createNewFile();
							BufferedWriter output = new BufferedWriter(new FileWriter(myfile, true));
							//output.write(actualNote);

							for(int i = 0; i < mylist.size(); i++)
							{
								System.out.println(mylist.get(i));
								output.write(mylist.get(i));
								output.newLine();

							};

							output.newLine();
							output.close();
						}
							catch(Exception e)
						{
							e.printStackTrace();
						};

						

						// then print out contents of the file
						// so now remove original file and print out the new lines to the new file

						an.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}






			// check if a reminder is required at this time
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

}
