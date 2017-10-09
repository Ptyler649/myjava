import java.util.Optional;

public class myex17{
	public static void main(String[] args){
		String[] in = new String[3];
		String op1 = Optional.of(in [2]).orElse("Empty");
		System.out.println(op1);
	}
}
