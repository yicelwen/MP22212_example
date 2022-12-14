package course.c10.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class TerminalShortCircuitOpDemo {

	public static void main(String args[]) {
		testFindFirst();
		testAllMatch();
		testNoneMatch();
		testFindAny();
		testAnyMatch();		
	}
	
	public static void testFindFirst() {
		Optional<String> val = 
				Stream.of("one", "two")
				.findFirst();
		System.out.println(val);
	}
	
	public static void testAllMatch() {
		List<String> list = Arrays.asList("jim1", "jim2", "jim3", "jim4");
		boolean containsJim = 
				list.stream()
				.allMatch(p -> p.contains("jim"));	
		boolean contains1 = 
				list.stream()
				.allMatch(p -> p.contains("1"));
		System.out.println(containsJim + " - " + contains1);
	}
	
	public static void testNoneMatch() {
		List<String> list = Arrays.asList("jim1", "jim2", "jim3", "jim4");
		boolean contains5 = 
				list.stream()
				.noneMatch(p -> p.contains("5"));
		System.out.println(contains5);
	}
	
	public static void testFindAny() {
		List<String> list = Arrays.asList("jim1", "jim2", "jim3", "jim4");
		Optional<String> val = 
				list.stream()
				.findAny();
		System.out.println(val);
	}
	
	public static void testAnyMatch() {
		boolean lengthOver5 = Stream.of("two", "three", "eighteen")
				.anyMatch(s -> s.length() > 5);
		System.out.println(lengthOver5);
	}

}
