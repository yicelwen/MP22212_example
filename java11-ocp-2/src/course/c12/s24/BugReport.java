package course.c12.s24;

@interface Reference {
	String id();
}

enum Status {
	UNCONFIRMED, CONFIRMED, FIXED, NOTABUG
}

public @interface BugReport {

	boolean repeatable();

	String assignedTo();

	String[] reportedBy();

	Class<?> testCase();

	Status status();

	Reference ref();
}
