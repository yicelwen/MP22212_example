package course.c11;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class ZonedDateTimeDemo1 {
	public static void main(String[] args) {
		
		LocalDateTime tpNow = 
				LocalDateTime
				.now()
				.truncatedTo(ChronoUnit.MINUTES);
		System.out.println("Now in Taipei : " + tpNow);

		ZoneId newYork = ZoneId.of("America/New_York");
		ZonedDateTime nyNow  = 
				ZonedDateTime
				.now(newYork)
				.truncatedTo(ChronoUnit.MINUTES);
		System.out.println("Now in NewYork: " + nyNow);
		System.out.println("Offset of NewYork: " + nyNow.getOffset());
		System.out.println("Time Zone: " + nyNow.getZone());
		
		ZonedDateTime time1 = ZonedDateTime.of(tpNow, newYork);
		System.out.println("Time-1: " + time1);
		
		ZonedDateTime time2 = time1.plusDays(1).minusMinutes(15);
		System.out.println("Time-2: " + time2);
	}
}
