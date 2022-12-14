package course.c12.s32;

public @interface Hurt {
	String veterinarian() default "unassigned";

	String value() default "foot";

	int age() default 1;

//	double test();
}
