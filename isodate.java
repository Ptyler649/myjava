import java.time.*;
import java.time.format.*;

public class isodate{
	public static void main(String[] args){
		String date = LocalDate
			.parse("2014-05-04")
			.format(DateTimeFormatter.ISO_DATE_TIME);

		System.out.println(date);
	
	}
}
