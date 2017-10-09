import java.io.Console;

public class myex6{
	public static void main(String[] args){
		Console c = System.console();
		char[] oldpass = c.readPassword("password: ");
	}
}
