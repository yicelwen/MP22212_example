package course.c11;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class PeriodAndDurationDemo {	
	public static void main(String[] args) {
		LocalDateTime beforeDST = 
				LocalDateTime.of(2022, 03, 12, 12, 00);
		ZonedDateTime t = ZonedDateTime
				.of(beforeDST, ZoneId.of("America/New_York"));
		// show Period
		Period day1Period = Period.ofDays(1);
		System.out.println("Period of 1 day: " + day1Period);
		System.out.println("Before: " + t);
		System.out.println(" After: " + t.plus(day1Period));
		// show Duration
		Duration hours24Duration = Duration.ofHours(24);
		System.out.println("Duration of 24 hours: " + hours24Duration);
		System.out.println("Before: " + t);
		System.out.println(" After: " + t.plus(hours24Duration));
	}
}
