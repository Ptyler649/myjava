import java.util.stream.Stream;

public class myex13{
	public static void main(String[] args){
		Stream < Integer > ints = Stream.of(1,2,3);
		ints.forEach((Integer i) -> {
			System.out.print(i * 2);
		});
		ints.forEach(System.out::print);
	}
}
