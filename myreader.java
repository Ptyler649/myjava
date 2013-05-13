import java.io.*;

public class myreader{
	public static void main(String[] args)
	{
		System.out.println("BufferedReader example!!");
		
		BufferedReader myread = new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
		String myinput = myread.readLine();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}