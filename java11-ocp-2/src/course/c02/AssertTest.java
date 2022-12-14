package course.c02;

enum Gender {
	MALE, FEMALE;
}

class MyTime {
	int hours;
	int minutes;
	int seconds;
	void rule() {
	    assert(0 <= hours && hours < 24);
	    assert(0 <= minutes && minutes < 60);
	    assert(0 <= seconds && seconds < 60);
	}
}

public class AssertTest {

	public static void main(String[] args) {
		internalInvariants(-1);
		controlFlowInvariants(Gender.MALE);
	}

	private static void internalInvariants(int x) {
		if (x > 0) {
			System.out.println(x > 0);
		} else {
			assert (x == 0) : "x < 0";
			System.out.println(x == 0);
		}
	}

	private static void controlFlowInvariants(Gender g) {
		switch (g) {
		case MALE: // ...
			break;
		case FEMALE: // ...
			break;
		default:
			assert false : "Unknown gender!!";
			break;
		}
	}

}
