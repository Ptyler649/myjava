import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.*;

public class getfileparms{
	private static final getfileparms instance = new getfileparms();

	private getfileparms(){};

	public static String getparms() throws IOException{

		List<String> lines=Files.readAllLines(Paths.get("test.csv"), Charset.forName("UTF-8"));
		for(String line:lines){
  			System.out.println(line);
		}

		return "p1|p2|p3";
    	}
}		
