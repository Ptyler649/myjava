import java.util.*;

public class myex8{
	public static void main(String[] args){
		Locale ENUS = new Locale.Builder().setLanguage("en").setRegion("US").build();
		System.out.println(ENUS.getDisplayLanguage(new Locale("fr")));
	}
}
