import java.util.Set;
import java.util.TreeSet;

public class myex4{
	public static void main(String[] args){
		Set set = new TreeSet < > ();
		set.add("A");
		set.add("D");
		set.pollFirst();
		System.out.println(set.ceiling("C"));
	}
}
