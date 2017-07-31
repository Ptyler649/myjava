import java.nio.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.io.*;

public class filesearch{
	private static final filesearch instance = new filesearch();

	private filesearch(){};

	public static String search(String file, String in) throws IOException{
		File f = new File(file);
		String out = "";

		boolean result = false;

		if(f.exists() && !f.isDirectory()){
			result = true;
		}

		if(result){
			List<String> lines = Files.readAllLines(Paths.get(file), Charset.forName("UTF-8"));
			for(String line : lines){
				//System.out.println(line);
				String[] splitline = line.split(",");
				if(splitline[0].equals(in)){
					out = splitline[1];
				}
			}
		}

		return out;
	}

}
