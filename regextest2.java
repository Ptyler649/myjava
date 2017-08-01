import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regextest2{
	private static final Pattern p = Pattern.compile("(CAP)([A-Z]{2})([A-Z]{6})([0-9]{14}).DAT");
	public static void main(String[] args) {
		// create matcher for pattern p and given string
		Matcher m = p.matcher("CAPUSACTPRF20170712150003.DAT");

		// if an occurrence if a pattern was found in a given string...
	    if (m.find()) {
	        // ...then you can use group() methods.
	        System.out.println(m.group(0)); // whole matched expression
	        System.out.println(m.group(1)); // first expression from round brackets (Testing)
	        System.out.println(m.group(2)); // second one (123)
	        System.out.println(m.group(3)); // third one (Testing)
	        System.out.println(m.group(4)); // forth group
	        
	    }
}

}


