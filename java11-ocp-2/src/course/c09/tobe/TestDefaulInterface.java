package course.c09.tobe;

import java.util.function.Predicate;

interface Filter extends Predicate<String> {
	public default boolean test(String str) {
		return str.equals("Java");
	}
}

class FilterImpl1 implements Filter {
}

class FilterImpl2 implements Filter {
	@Override
	public boolean test(String str) {
		return str.equals("Duke");
	}
}

public class TestDefaulInterface {

	public static void main(String[] args) {

		System.out.println(new FilterImpl1().test("Java"));
		System.out.println(new FilterImpl2().test("Java"));
		System.out.println(new FilterImpl2().test("Duke"));

	}

}
