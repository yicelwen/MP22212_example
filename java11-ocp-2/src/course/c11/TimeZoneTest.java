package course.c11;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.zone.ZoneRules;

public class TimeZoneTest {
	public static void main(String[] args) {
		// ZoneId
		ZoneId taipei = ZoneId.systemDefault();
		// System.out.println("Zone ID: " + taipei.getId());
		ZoneId newYork = ZoneId.of("America/New_York");
		// System.out.println("Zone ID: " + newYork.getId());
		
		// ZoneId >> ZoneRules
		ZoneRules taipeiRules = taipei.getRules();
		ZoneRules newyorkRules = newYork.getRules();

		//US started DST
		Instant beforeUsDST = Instant.parse("2022-03-12T00:00:00Z");
		Instant inUsDST = Instant.parse("2022-03-14T00:00:00Z");
		Instant now = Instant.now();

		System.out.println("Method Call\t\t" 
				+ "Taipei\t" 
				+ "NewYork(inDST)\t" 
				+ "NewYork(beforeDST)");
		System.out.println("-----------------------------------------------");

		System.out.println("isDaylightSavings():\t" 
				+ taipeiRules.isDaylightSavings(now) + "\t\t"
				+ newyorkRules.isDaylightSavings(inUsDST) + "\t\t" 
				+ newyorkRules.isDaylightSavings(beforeUsDST));
		
		System.out.println("getDaylightSavings():\t" 
				+ taipeiRules.getDaylightSavings(now).toHours() + "\t\t"
				+ newyorkRules.getDaylightSavings(inUsDST).toHours() + "\t\t"
				+ newyorkRules.getDaylightSavings(beforeUsDST).toHours());

		ZoneOffset os = taipeiRules.getOffset(LocalDateTime.now());
		System.out.println("getOffset():\t\t" 
				+ os + "\t\t" 
				+ newyorkRules.getOffset(inUsDST) + "\t\t" 
				+ newyorkRules.getOffset(beforeUsDST));
		
		ZoneOffset sos = taipeiRules.getStandardOffset(now);
		System.out.println("getStandardOffset():\t" 
				+ sos + "\t\t"
				+ newyorkRules.getStandardOffset(inUsDST) + "\t\t" 
				+ newyorkRules.getStandardOffset(beforeUsDST));
	}
}
