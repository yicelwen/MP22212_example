package course.c12.s23;

public @interface Exercise {
	int hoursPerDay();

	int startHour() default 6;
}
