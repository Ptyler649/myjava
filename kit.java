import java.io.*;

public class kit{
	public static void main(String[] args)
	{
		System.out.println("Hello sir...");
		instructKit();
	}
	
	static void instructKit()
	{
		try
		{
			Console c = System.console();	
			System.out.print(":");
			String kitsInstruction = c.readLine();
			
			if(kitsInstruction.equals("exit"))
					return;
		
			if(kitsInstruction.equals("scan"))
			{
				System.out.println("Scanning.");
				for(int x = 0; x < 10; x++)
					{
					System.out.print(".");
					Thread.sleep(200);
					}
				System.out.println("");
				System.out.println("Scan complete sir.");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	
	instructKit();
	
	}

}