package course.c11;

import java.time.Instant;

public class InstantDemo {
	public static void main(String[] args) throws InterruptedException {
		Instant now = Instant.now();
		Thread.sleep(0, 1); // long milliseconds, int nanoseconds
		Instant later = Instant.now();
		System.out.println("now is before later? " + now.isBefore(later));
		System.out.println("  Now: " + now);
		System.out.println("Later: " + later);
		Instant epoch = Instant.parse("1970-01-01T00:00:00Z");
		System.out.println("EPOCH: " + epoch);
	}
}
