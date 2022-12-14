package course.c12.s31;

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
	@Anno @Anno2
	public Dog(@Anno Integer age) {
	}

	@Anno @Anno2
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
