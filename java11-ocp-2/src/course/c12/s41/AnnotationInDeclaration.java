package course.c12.s41;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// @Target({ElementType.TYPE_USE, ElementType.METHOD})
@Target(ElementType.TYPE_USE)
@interface Anno {
}

@interface Anno2 {
}

@FunctionalInterface
interface Runner {
	void go(String name);
}

@Anno
@Anno2
class Dog {
	@Anno
	public Dog(@Anno Integer age) {
	}

	@Anno	// 編譯失敗
	public void eat(@Anno String input) {
		@Anno
		String m = (@Anno String) "test";
		Runner r1 = new @Anno Runner() {
			public void go(@Anno @Anno2 String name) {
				System.out.print(name);
			}
		};
		Runner r2 = (@Anno String n) -> System.out.print(n);
	}
}

public class AnnotationInDeclaration {

}
