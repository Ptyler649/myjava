package myjava;

import java.io.*;

public class extra{
	public String myinput()
	{
		String myin = "";
		System.out.println("input");
		BufferedReader myread = new BufferedReader(new InputStreamReader(System.in));

		try
		{
			myin = myread.readLine();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return myin;
	}

	public void mywrite(String filename)
	{
		System.out.println("write a file: "+filename);

		BufferedWriter mywrite = null;
	}
}
