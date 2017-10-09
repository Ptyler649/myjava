import java.io.FileReader;
import java.io.IOException;

public class myex14{
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("new.txt");
		System.out.println(fr.read());
		fr.close();
	}
}
