import java.util.*;
import java.nio.*;
import java.nio.file.*;
import java.io.*;
import java.nio.charset.*;

public class addtofile{
	public static void main(String[] args) throws IOException{
		List<String> lines = Arrays.asList("first", "second");
		Path file = Paths.get("thefilename.txt");
		Files.write(file, lines, Charset.forName("UTF-8"));

		File f = new File("thefilename.txt");

		for(int x = 0; x < 10; x++){
			try{
				System.out.println("working: "+x);
				Thread.sleep(1000);
				Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);

				long out = f.length();
				System.out.println("file size:"+out);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		};


	}
}
