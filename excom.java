import java.io.*;

public class excom{
	public static void main(String[] args){
		p = Runtime.getRuntime().exec("host -t a " + domain);
    		p.waitFor();

    		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

    		String line = "";
    		while ((line = reader.readLine())!= null) {
			sb.append(line + "\n");
    		}
	}
}

