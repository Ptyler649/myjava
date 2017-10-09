import java.util.Comparator;

public class myex2{
	public static void main(String[] args){
		Comparator comp = Comparator.nullsLast(Integer::compare);
		System.out.println(comp.compare(null, 10));
	}
}
