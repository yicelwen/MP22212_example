package course.c12.s44;

import java.lang.annotation.Annotation;

public class InheritedUsage {
	public static void main(String[] args) {
		for (Annotation anno : MySub.class.getAnnotations()) {
			System.out.println(anno.annotationType().getName());
		}
	}
}
