import java.io.IOException;
import java.nio.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class myex15{
	public static void main(String[] args){
	       try{
		Path path = Paths.get("input.txt");
		Stream < String > stream = Files.readAllLines(path);
		stream.limit(1).forEach(System.out::print);
	       }
		catch(IOException ex){
			System.out.println("Error!");
		}
	}
}
