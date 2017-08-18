import java.util.*;
import java.io.*;

import java.nio.file.*;
import java.nio.charset.*;

public class a{

public static void main(String[] args) throws InterruptedException, IOException{

	for(;;){
		Thread.sleep(1000);
		int out = randInt(0,1);

		// access memory and retrieve learning experience for this action
		double score = accessmemory(out);
		
		// decision based on experience
		
		if(score > 50){
			System.out.println(out);
		}
		else
			System.out.println(".");

	}
}

public static int randInt(int min, int max){
	Random r = new Random();
	int rn = r.nextInt((max - min) + 1) + min;
	return rn;
}

public static double accessmemory(int in) throws IOException{

	double numoccurred = getnumoccurred(in,"amem.csv");
	double numposreinf = getnumposreinf(in,"amem.csv");
	double experience = (numposreinf / numoccurred)*100;
	
	return experience;
}

public static double getnumoccurred(int in, String filename) throws IOException{
	List<String> memcontents = Files.readAllLines(new File(filename).toPath(), Charset.forName("UTF-8"));

	String compare = Integer.toString(in);
	double out = 0;
	for(String line : memcontents){
		String[] field = line.split(",");
		if(field[0].equalsIgnoreCase(compare)){
			out++;
		}		
	};
	return out;
}

public static double getnumposreinf(int in, String filename) throws IOException{
	List<String> memcontents = Files.readAllLines(new File(filename).toPath(), Charset.forName("UTF-8"));

	String compare = Integer.toString(in);
	double out = 0;
	for(String line : memcontents){
		String[] field = line.split(",");
		if(field[1].equalsIgnoreCase(compare)){
			Integer calc = Integer.valueOf(field[1]);
			out=out+calc;
		}		
	};
	return out;

}


}


