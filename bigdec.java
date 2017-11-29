import java.math.BigDecimal;

public class bigdec{
	public static void main(String[] args){
		String s = "1234";
		System.out.println(s);

		String t = "1010|dslkfjs";
		String[] out = t.split("|");
		//System.out.println(out[0]);

		for(String yy : out){
			System.out.println(yy);
		};
		

		//Integer i = Integer.valueOf(s);

		BigDecimal b = new BigDecimal(Integer.valueOf(s));
	}
}
