import java.io.*;
import java.util.*;

public class myjarvis{
	public static void main(String[] args)
	{
		String myinput = "";
		System.out.println("Good day sir, how are you?");

		BufferedReader myread = new BufferedReader (new InputStreamReader(System.in));


		
		

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


			// greetings
			if(myinput.equals("fine"))
			{
				System.out.println("I am glad to here that sir!!!");
			}
			else
			{
				System.out.println("ok, sir!");
			}

			// appointment for today
			// get sysdate
			Date d = new Date();
			String sysdate = d.toString();
			System.out.println(sysdate);

			String currTime24 = sysdate.substring(11,16);

			
			// convert to standard day time
			String currTimeSTD = sysdate.substring(11,13);
			int foo = Integer.parseInt(currTimeSTD);
			if(foo > 12)
			{
				foo = foo - 12;
			};
			currTimeSTD = foo + ":" + sysdate.substring(14,16);
			// need to pad with 0's



			System.out.println("24 clock time is :"+currTime24);
			System.out.println("Standard clock time is : "+currTimeSTD);




		


			// bye
			if(myinput.equals("bye"))
			{
				x = 99;
			}

		}

	}

}