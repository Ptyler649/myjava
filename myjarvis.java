import java.io.*;

public class myjarvis{
	public static void main(String[] args)
	{
		String myinput = "";
		System.out.println("Good day sir, how are you?");

		BufferedReader myread = new BufferedReader (new InputStreamReader(System.in));


		int x = 0;

		while (x != 99)
		{
			try
			{
				myinput = myread.readLine();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}


			if(myinput.equals("fine"))
			{
				System.out.println("I am glad to here that sir!!!");
			}
			else
			{
				System.out.println("ok, sir!");
			}

			if(myinput.equals("bye"))
			{
				x = 99;
			}

		}

	}

}