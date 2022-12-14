package course.c11;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import static java.lang.System.out;

public class LocalTimeExample {
	public static void main(String[] args) {
		LocalTime now = LocalTime.now();
		out.println("Now is: " + now);
		
		LocalTime nowPlus = 
				now.plusHours(1).plusMinutes(15);
		out.println("The Time after 1 hour 15 minutes: " + nowPlus);
		
		LocalTime nowHrsMins = 
				now.truncatedTo(ChronoUnit.MINUTES);
		out.println("Truncate now to minutes: " + nowHrsMins);
		out.println("Now is " + now.toSecondOfDay() 
									+ " seconds after midnight");
		LocalTime lunch = LocalTime.of(12, 5);
		out.println("Do I miss lunch? " + lunch.isBefore(now));

		long minsUntilLunch = 
				now.until(lunch, ChronoUnit.MINUTES);
		out.println("Minutes until lunch: " + minsUntilLunch);
		
		LocalTime bedtime = LocalTime.of(23, 20);
		long hrsToBedtime = now.until(bedtime, ChronoUnit.HOURS);
		out.println("How many hours until bedtime? " + hrsToBedtime);
	}
}