package course.c11;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class FluentDemo {	
	public static void main(String[] args) {
		LocalDate myDay0 = LocalDate.of(1977, 6, 11);
		LocalDate myDay1 = Year.of(1977).atMonth(06).atDay(11);
		
		LocalDateTime meeting = 
			LocalDate.of(2022, 07, 10).atTime(11, 30);
		
		ZonedDateTime host = 
			meeting.atZone(ZoneId.systemDefault());
		System.out.println(host);
		ZonedDateTime meetingUK = 
			host.withZoneSameInstant(ZoneId.of("Europe/London"));
		System.out.println(meetingUK);
		ZonedDateTime meetingSF = 
			host.withZoneSameInstant(ZoneId.of("America/New_York"));
		System.out.println(meetingSF);
	}
}
