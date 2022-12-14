package course.c10.optional;

import static java.lang.System.err;
import static java.lang.System.out;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalDemo {

	private static void testNull() {
		char str[] = { 'D', 'u', 'k', 'e' };
		String s = null;
		for (char c : str) {
			s = s + c;
		}
		System.out.println(s);
		Object o = null;
		System.out.println(o);
		// System.out.println(null); //can't compiled!!
	}

	private static Double averageWithNull(int... scores) {
		if (scores.length == 0)
			return null;
		int sum = 0;
		for (int score : scores)
			sum += score;
		return (double) sum / scores.length;
	}

	private static Optional<Double> averageWithOptional(int... scores) {
		if (scores.length == 0)
			return Optional.empty();
		int sum = 0;
		for (int score : scores)
			sum += score;
		return Optional.of((double) sum / scores.length);
	}


	private static Integer getLength4map(String in) {
		return in.length();
	}
	private static Optional<Integer> getLength4flatMap(String in) {
		return Optional.ofNullable(in).map(s -> s.length());
	}
	private static void mapAndFlapMap() {
		
		String str = null;
		
		Optional<Integer> oi1 = 
				Optional.ofNullable(str)
						.map(OptionalDemo::getLength4map);
		
		System.out.println(oi1);
		
		Optional<Integer> oi2 = 
				Optional.ofNullable(str)
						.flatMap(OptionalDemo::getLength4flatMap);
		
		System.out.println(oi2);
	}
	
	

	public static void main(String[] args) {
		
		testOptionalOfJava8();
		
//		testNull();
//		averageWithNull();
//
//		mapAndFlapMap();
//		
//		testOptionalAfterJava8();
//		
//		String name = "jim";
//		System.out.println(getTotalSalary(name));
//		name = null;
//		System.out.println(getTotalSalary2(name));
		
	}

	private static void testOptionalOfJava8() {
		out.println("show01: " + averageWithOptional(90, 100)); 
		out.println("show02: " + averageWithOptional()); 

		Optional<Double> optOK = averageWithOptional(90, 100);
		if (optOK.isPresent()) {
			out.println("show03: " + optOK.get()); 
		}
		Optional<Double> optNG = averageWithOptional();
		try {
			optNG.get();
		} catch (NoSuchElementException e) {
			err.println("show04 throws: " + e.getClass());
		}

		Optional<Double> opt1 = averageWithOptional(90, 100);
		opt1.ifPresent(d -> out.println("show05: " + d));
		
		// there is value in it
		Optional<Double> opt2 = averageWithOptional(90, 100);	
		out.println("show06: " + opt2.orElse(Double.NaN));
		out.println("show07: " + opt2.orElseGet(() -> Math.random()));
		out.println("show08: " + opt2.orElseThrow(() -> new MyOptionalException()));
		
		// there is no value in it
		Optional<Double> opt3 = averageWithOptional();	
		System.out.println("show09: " + opt3.orElse(Double.NaN));
		out.println("show10: " + opt3.orElseGet(() -> Math.random()));
		try {
			opt3.orElseThrow(() -> new MyOptionalException());
		} catch (MyOptionalException e) {
			err.println("show11 throws: " + e.getClass());
		}

	}

	private static void testOptionalAfterJava8() {

		Optional<String> o1 = Optional.of("value");
		Optional<String> o2 = Optional.empty();

		// ifPresentOrElse()
		o1.ifPresentOrElse(
				s -> System.out.println("Found " + s), 
				() -> System.out.println("Not found"));
		o2.ifPresentOrElse(
				s -> System.out.println("Found " + s), 
				() -> System.out.println("Not found"));

		// or()
		o1 = o1.or(() -> Optional.of("default"));
		System.out.println(o1); 	// Optional[value]
		o2 = o2.or(() -> Optional.of("default"));
		System.out.println(o2); 	// Optional[default]

		// orElseThrow()
		System.out.println(o1.orElseThrow()); // value
		System.out.println(o2.orElseThrow()); // java.util.NoSuchElementException: No value present

		// isEmpty()
		System.out.println(o1.isEmpty()); // false
		System.out.println(o2.isEmpty()); // true

	}
	
	private static Integer getTotalSalary(String name) {
	    return Optional.ofNullable(name)			// Optional<String>
	            .stream()							// Stream<String>
	            .map(OptionalDemo::findUsersByName)	// Stream<List<User>>
	            .flatMap(Collection::stream)		// Stream<User>
	            .map(User::getSalary)				// Stream<Integer>
	            .mapToInt(Integer::valueOf)			// IntStream
	            .sum();			
	           
	}
	
	private static Integer getTotalSalary2(String name) {
		return Optional.ofNullable(name)			// Optional<String>
				.map(OptionalDemo::findUsersByName)	// Optional<List<User>>
				.stream()							// Stream<List<User>> 
				.flatMap(Collection::stream)		// Stream<User>
				.map(User::getSalary)				// Stream<Integer>    
				.mapToInt(i -> i)					// IntStream
				.sum();	
	
	   
	}
	
	private static List<User> findUsersByName(String name) {
		return List.of(new User("jim1", 1000), 
						new User("jim2", 1000), 
						new User("duke", 1000))
				.stream()
				.filter(u -> u.getName().contains(name))
				.collect(Collectors.toList());
	}

}


