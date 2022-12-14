package course.c11;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeDemo2 {
	public static void main(String[] args) {
		ZoneId usEast = ZoneId.of("America/New_York");
		// DST Begins: 2022/03/13
		LocalDateTime beforeStartDTS = 
				LocalDateTime.of(2022, 03, 12, 16, 00);
		ZonedDateTime timeS1 = 
				ZonedDateTime.of(beforeStartDTS, usEast);
		System.out.println("TimeS-1: " + timeS1);
		ZonedDateTime timeS2 = timeS1.plusDays(1);
		System.out.println("TimeS-2: " + timeS2);
		ZonedDateTime timeS3 = timeS1.plusHours(24);
		System.out.println("TimeS-3: " + timeS3);
		// DST Ends: 2022/11/06 
		LocalDateTime beforeEndDTS = 
				LocalDateTime.of(2022, 11, 05, 16, 00);
		ZonedDateTime timeE1 = 
				ZonedDateTime.of(beforeEndDTS, usEast);
		System.out.println("TimeE-1: " + timeE1);
		ZonedDateTime timeE2 = timeE1.plusDays(1);
		System.out.println("TimeE-2: " + timeE2);
		ZonedDateTime timeE3 = timeE1.plusHours(24);
		System.out.println("TimeE-3: " + timeE3);
	}
}
