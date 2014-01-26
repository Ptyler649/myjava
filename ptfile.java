import java.io.*;

public class ptfile{
	public static void main(String[] args)
	{
		System.out.println("ptfile example");
		
		try
		{
			File myfile = new File("myptfile.txt");
			//myfile.createNewFile();
			//System.out.println(myfile.exists());
			
			if(myfile.exists())
				System.out.println("Already Exists");
			else
			{
				// created a file
				myfile.createNewFile();
				System.out.println("Created a new file");
				PrintWriter pw = new PrintWriter(myfile);
				pw.println("hehehe");
				pw.close();
				
				// read the file back into memory and print out
				FileReader fr = new FileReader(myfile);
				BufferedReader br = new BufferedReader(fr);
				String aline = br.readLine();
				System.out.println(aline);
			}
			
				
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}