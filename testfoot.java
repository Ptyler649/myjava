import java.io.*;
import java.util.*;

public class testfoot{

	//Timer timer = new Timer();

	public static void main(String[] args)
	{
	
		TimerTask task = new TimerTask() {
  		@Override
  		public void run() {
    		//do some processing
    		System.out.println("!!!!!!!!");
  		}
		};

		Timer timer = new Timer();
		timer.schedule(task, 0l, 4000l); //call the run() method at 1 second intervals

		System.out.println("mmmmmmm");

		BufferedReader myread = new BufferedReader (new InputStreamReader(System.in));
		String myinput = "";

		Boolean keepgoing = true;
		while (keepgoing)
		{
		// take input
			try
			{
				myinput = myread.readLine();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			};

		
		if(myinput.equals("stop"))
		{
			timer.cancel();
		}

		// need a way to continue once stopped


		
		}


	}

}

