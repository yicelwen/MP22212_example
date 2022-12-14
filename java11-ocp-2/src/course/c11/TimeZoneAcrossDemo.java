package course.c11;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneAcrossDemo {
	public static void main(String[] args) {
		LocalDateTime meeting = LocalDateTime.of(2022, 07, 10, 11, 30);
		
		ZoneId taipei = ZoneId.systemDefault();
		ZonedDateTime host = ZonedDateTime.of(meeting, taipei);
		OffsetDateTime offset = host.toOffsetDateTime();
		
		ZoneId london = ZoneId.of("Europe/London");
		ZonedDateTime callLondon = offset.atZoneSameInstant(london);
		
		ZoneId newYork = ZoneId.of("America/New_York");
		ZonedDateTime callNewYork = offset.atZoneSameInstant(newYork);
		
		System.out.println("conf call  (Taipei) at: " + host);
		System.out.println("conf call  (London) at: " + callLondon);
		System.out.println("conf call (NewYork) at: " + callNewYork);
	}
}
