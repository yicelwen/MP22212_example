package course.c11;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;
import static java.lang.System.out;

public class LocalDateExample {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		out.println("Now: " + now);

		LocalDate d = LocalDate.of(1995, 5, 23); // Java's Birthday
		out.println("Java's birthday: " + d);
		out.println("Is Java's birthday in the past? " + 
							d.isBefore(now));
		out.println("Is Java's birthday in a leap year? " + 
							d.isLeapYear());
		out.println("Java's birthday day of the week: " + 
							d.getDayOfWeek());
		out.println("Java's birthday day of the Month: " + 
							d.getDayOfMonth());
		out.println("Java's birthday day of the Year: " + 
							d.getDayOfYear());
		
		LocalDate nowAfter1Month = now.plusMonths(1);
		out.println("The date after 1 month: " + nowAfter1Month);
		
		LocalDate nextMonday = 
				now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		out.println("First Monday after now: " + nextMonday);
	}
}