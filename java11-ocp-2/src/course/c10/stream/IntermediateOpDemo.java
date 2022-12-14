package course.c10.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// filter() map() peek() sorted()
public class IntermediateOpDemo {

	public static void main(String args[]) {
//		createStream();
//		testFilter();
//		testMap();
//		testMapToInt();
//		testPeek();
		testSorted();
//		testComparing();

	}

	@SuppressWarnings("unused")
	public static void createStream() {

		Stream<String> s1 = Arrays.asList("1", "2", "3", "4").stream();
		Stream<Integer> s2 = Arrays.asList(1, 2, 3, 4).stream();

		Stream<String> s3 = Stream.of("1", "2", "3", "4");
		Stream<Integer> s4 = Stream.of(1, 2, 3, 4);

		Stream<String> s5 = Arrays.stream(new String[] {"1", "2", "3", "4"});
		IntStream s6 = Arrays.stream(new int[] {1, 2, 3, 4});
		
		s1.forEach(System.out::println);
	}

	public static void testFilter() {
		/*
		Predicate<Integer> predicate0 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t.intValue() < 3;
			}
		};*/
		Predicate<Integer> predicate = t -> t.intValue() < 3;
		Stream<Integer> lessThan3 = 
				Stream.of(1, 2, 3, 4)
				.filter(predicate);
		System.out.println(Arrays.asList(lessThan3.toArray()));
	}
	

	public static void testMap() {
		Function<Integer, Integer> mapper = n -> 2 * n;
		/*		
		Function<Integer, Integer> mapper = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer t) {
				return 2 * t;
			}
		};	*/
		Stream<Integer> mapResult = 
				Stream.of(1, 2, 3, 4)
				.map(mapper);
		
		Object[] arr = mapResult.toArray();
		List<Object> list = Arrays.asList(arr);
		System.out.println(list);
	}



	public static void testMapToInt() {
		ToIntFunction<String> mapper = Integer::parseInt;
		// ToIntFunction<String> mapper = s -> Integer.parseInt(s);		
		/*
		ToIntFunction<String> mapper = new ToIntFunction<String>() {
			@Override
			public int applyAsInt(String value) {
				return Integer.parseInt(value);
			}
		};	*/
		IntStream mapResult = 
				Stream.of("a1", "a2", "a3")
				.map(s -> s.substring(1))
				.mapToInt(mapper);
		mapResult.forEach(i -> System.out.print(i + ", "));
	}
	


	public static void testPeek() {
		/*		
		Consumer<Integer> action = new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.print(t);
			}
		};	*/
		// Consumer<Integer> action = t -> System.out.println(t);
		Consumer<Integer> action = System.out::println;

		Stream<Integer> stream = 
				Stream.of(1, 2, 3, 4)
				.peek(action);
				
		/* Streams may be lazy. 
		   Computation on the source data is performed only when the terminal operation is initiated, 
		   and source elements are consumed only as needed.*/
		System.out.println("Length: " + stream.toArray().length);
	}
	
	
	public static void testSorted() {
		List<String> lt = Arrays.asList("a2", "a1", "b1", "c2", "c1");
		lt.stream()
			.sorted()
			.forEach(s -> System.out.print(s + ", "));
		System.out.println();
		lt.stream()
			.sorted(String::compareTo)
			.forEach(s -> System.out.print(s + ", "));
		System.out.println();
		lt.stream()
			.sorted((s1, s2) -> s1.compareTo(s2) * -1)
			.forEach(s -> System.out.print(s + ", "));
	}
	

	public static void testComparing() {
		List<Person> people = Arrays.asList(
				new Person("Max", 18), 
				new Person("Peter", 23),
				new Person("Pamela", 23), 
				new Person("David", 12));
		Function<Person, String> getPersonNames = Person::getName;
		Function<Person, Integer> getPersonAges = Person::getAge;
		
		Comparator<Person> comp = 
				Comparator.comparing(getPersonAges)
						  .thenComparing(getPersonNames);			
		
		people.stream()
			.sorted(comp)
			.forEach(s -> System.out.print(s + ", "));
		
		System.out.println();

		people.stream()
			.sorted(comp.reversed())
			.forEach(s -> System.out.print(s + ", "));
	}
		
}
