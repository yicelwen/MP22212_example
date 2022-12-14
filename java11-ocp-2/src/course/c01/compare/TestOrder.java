package course.c01.compare;

import java.util.Calendar;
import static java.lang.System.out;

public class TestOrder {

	public static void main(String[] args) {

		Calendar today = Calendar.getInstance();
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		out.println(today.compareTo(tomorrow));

		out.println("A".compareTo("B"));
		
		out.println(Integer.valueOf(5).compareTo(Integer.valueOf(6)));
		
	}

}
