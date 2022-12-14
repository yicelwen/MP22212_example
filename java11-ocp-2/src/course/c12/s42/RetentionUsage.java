package course.c12.s42;

import java.lang.annotation.Annotation;

@Anno1
@Anno2
@Anno3
public class RetentionUsage {
	public static void main(String[] args) {
		for (Annotation anno : RetentionUsage.class.getAnnotations()) {
			System.out.println(anno.annotationType().getName());
		}
	}
}
