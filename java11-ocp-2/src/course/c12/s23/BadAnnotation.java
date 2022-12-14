package course.c12.s23;

public @interface BadAnnotation {
	String name() default new String(""); // 編譯失敗
	String address() default "";
	String title() default null; // 編譯失敗
}