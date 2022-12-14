package course.c11;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DayDiffDemo {
	public static void main(String[] args) {
		LocalDate christmas = LocalDate.of(2022, 12, 25);
		LocalDate today = LocalDate.now();
		System.out.println("Today is " + today);
		long days = ChronoUnit.DAYS.between(today, christmas);
		System.out.println("There are " + days + " days until Christmas");
		Period untilXMas = Period.between(today, christmas);
		System.out.println("There are " 
				+ untilXMas.getMonths() + " months, "
				+ untilXMas.getDays() + " days until Christmas");
	}
}
