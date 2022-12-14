package course.c11;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.zone.ZoneOffsetTransition;

public class ZoneOffsetTransitionDemo {
	// Ask the rules if there was a gap or overlap
	private static void gapOrOverlap(ZoneId usEast, LocalDateTime dt) {
		ZoneOffsetTransition zot = usEast.getRules().getTransition(dt);
		System.out.print(dt + " is ");
		if (zot != null) {
			if (zot.isGap())
				System.out.println("gap");
			if (zot.isOverlap())
				System.out.println("overlap");
		} else {
			System.out.println("-- ");
		}
	}
	public static void main(String[] args) {
		ZoneId usEast = ZoneId.of("America/New_York");
		// DST Begins: 2022/03/13, 02->03
		gapOrOverlap(usEast, LocalDateTime.of(2022, 03, 13, 1, 59));
		gapOrOverlap(usEast, LocalDateTime.of(2022, 03, 13, 2, 01));
		gapOrOverlap(usEast, LocalDateTime.of(2022, 03, 13, 2, 59));
		gapOrOverlap(usEast, LocalDateTime.of(2022, 03, 13, 3, 01));
		// DST Ends: 2022/11/06 , 02->01
		gapOrOverlap(usEast, LocalDateTime.of(2022, 11, 6, 0, 59));
		gapOrOverlap(usEast, LocalDateTime.of(2022, 11, 6, 1, 01));
		gapOrOverlap(usEast, LocalDateTime.of(2022, 11, 6, 1, 59));
		gapOrOverlap(usEast, LocalDateTime.of(2022, 11, 6, 2, 01));
	}
}
