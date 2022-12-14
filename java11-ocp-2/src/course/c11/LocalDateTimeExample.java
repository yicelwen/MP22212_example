package course.c11;

import java.time.*;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import static java.lang.System.out;

public class LocalDateTimeExample {
	public static void main(String[] args) {
		LocalDate flightDate = LocalDate.of(2022, Month.JULY, 2);
		LocalTime flightTime = LocalTime.of(21, 45);
		LocalDateTime flight = LocalDateTime.of(flightDate, flightTime);
		out.println("Airplane leaves: " + flight);
		
		LocalDateTime seminarStart = 
				LocalDateTime.of(2022, Month.JULY, 2, 9, 30);
		out.println("Seminar starts: " + seminarStart);
		LocalDateTime seminarEnd = 
				seminarStart.plusDays(2).plusHours(8);
		out.println("Seminar ends: " + seminarEnd);
		
		long seminarHrs = 
				seminarStart.until(seminarEnd, ChronoUnit.HOURS);
		out.println("Seminar is: " + seminarHrs + " hours long.");
	}
}