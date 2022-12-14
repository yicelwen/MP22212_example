package course.c08;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatDate {
	public static void useDateFormat() {
		System.out.println("==================== UseDateFormat()");
		Date today = new Date();
		Locale locale = Locale.US;
		DateFormat df;

		df = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		System.out.println("DateFormat.DEFAULT: " + df.format(today));

		df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		System.out.println("DateFormat.SHORT: " + df.format(today));

		df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		System.out.println("DateFormat.MEDIUM: " + df.format(today));

		df = DateFormat.getDateInstance(DateFormat.LONG, locale);
		System.out.println("DateFormat.LONG: " + df.format(today));

		df = DateFormat.getDateInstance(DateFormat.FULL, locale);
		System.out.println("DateFormat.FULL: " + df.format(today));
	}
	public static void useSimpleDateFormat() {
		System.out.println("==================== UseSimpleDateFormat()");
		Date today = new Date();
		Locale locale = Locale.US;
		DateFormat df;

		df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
		System.out.println(df.format(today));

		df = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss", locale);
		System.out.println(df.format(today));

		df = new SimpleDateFormat("yyyy/MMMM/dd HH:mm:ss", locale);
		System.out.println(df.format(today));
	}
	public static void main(String[] args) {
		useDateFormat();
		useSimpleDateFormat();
	}
}
