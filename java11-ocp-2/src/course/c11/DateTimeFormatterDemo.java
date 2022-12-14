package course.c11;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatterDemo {

	public static void main(String[] args) {
		ZonedDateTime now = ZonedDateTime.now();
		DateTimeFormatter formatter = null;
		
		formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		System.out.println(now.format(formatter));
		
		formatter = DateTimeFormatter.ISO_ORDINAL_DATE;
		System.out.println(now.format(formatter));
		
		formatter = DateTimeFormatter
				.ofPattern("EEEE, MMMM dd, yyyy G, hh:mm a VV");
		System.out.println(now.format(formatter));
		
		formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println(now.format(formatter));

	}

}
