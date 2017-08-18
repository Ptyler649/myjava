import java.util.*;
import java.io.*;

import java.nio.file.*;
import java.nio.charset.*;

public class a{

public static void main(String[] args) throws InterruptedException, IOException{

	for(;;){
		Thread.sleep(1000);
		int out = randInt(0,5);

		// access memory and retrieve learning experience for this action
		Double score = accessmemory(out);
		
		// decision based on experience
		if(score < 50){
			System.out.println(out);
		};

	}
}

public static int randInt(int min, int max){
	Random r = new Random();
	int rn = r.nextInt((max - min) + 1) + min;
	return rn;
}
public static double accessmemory(int in) throws IOException{

	Double numoccurred = 0.0;
	Double numposreinf = 0.0;
	Double experience = 0.0;
	numoccurred = getnumoccurred(in,"amem.csv");
	numposreinf = getnumposreinf(in,"amem.csv");
	
	if(numoccurred > 0.0 && numposreinf > 0.0){
		experience = (numposreinf / numoccurred)*100;
	}
	
	return experience;
}

public static Double getnumoccurred(int in, String filename) throws IOException{
	List<String> memcontents = Files.readAllLines(new File(filename).toPath(), Charset.forName("UTF-8"));

	String compare = Integer.toString(in);
	Double out = 0.0;
	for(String line : memcontents){
		String[] field = line.split(",");
		if(field[0].equalsIgnoreCase(compare)){
			out++;
		}		
	};
	return out;
}

public static Double getnumposreinf(int in, String filename) throws IOException{
	List<String> memcontents = Files.readAllLines(new File(filename).toPath(), Charset.forName("UTF-8"));

	String compare = Integer.toString(in);
	Double out = 0.0;
	for(String line : memcontents){
		String[] field = line.split(",");
		if(field[0].equalsIgnoreCase(compare)){
			Integer calc = Integer.valueOf(field[1]);
			out=out+calc;
		}		
	};
	return out;
}


}


