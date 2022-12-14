package course.c10.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOpCollectDemo {
	
	private static List<Person> getPersonList() {
		List<Person> persons = Arrays
		.asList(new Person("Max", 18), 
				new Person("Peter", 23),
				new Person("Pamela", 23), 
				new Person("David", 12));
		return persons;
	}
	
	public static void main(String args[]) {
		testToListToSet();
		testToMap();
		testAveragingDouble();
		testJoining();
		testGroupingBy();
		testPartitioningBy();
		testMappingFlatMapping();
		testFiltering1();
		testFiltering2();
	}
	
	private static void testToListToSet() {
		String[] sArr = new String[] {"jim1", "jim2", "jim1", "jim2"};
		
		Stream<String> s1 = Stream.of(sArr);
		Set<String> set = s1.collect(Collectors.toSet());	
		set.forEach(i -> System.out.print(i + ", "));	
		System.out.print("\n------------------\n");
		Stream<String> s2 = Stream.of(sArr);
		List<String> list = s2.collect(Collectors.toList());
		list.forEach(i -> System.out.print(i + ", "));
	}
	
	
	private static void testToMap() {
		Map<String, Integer> map = getPersonList().stream()
				.collect(Collectors.toMap(Person::getName, Person::getAge));
		System.out.println(map);
	}


	private static void testAveragingDouble() {
		Double averageAge = 
				getPersonList().stream()
				.collect(Collectors.averagingDouble(p -> p.age));
		System.out.println(averageAge);	// 19.0
	}


	private static void testJoining() {
		List<String> sl = Arrays.asList("a", "b", "c", "d");
		
		String s1Join = sl.stream().collect(Collectors.joining());
		System.out.println(s1Join);	
		
		String s2Join = sl.stream().collect(Collectors.joining("-"));
		System.out.println(s2Join);	
		
		String s3Join = sl.stream().collect(Collectors.joining("-", "/*", "*/"));
		System.out.println(s3Join);	
	}
	


	private static void testGroupingBy() {
		/*
		Function<Person, Integer> classifier = 
			new Function<Person, Integer>() {
					public Integer apply(Person t) {
						return t.age;
					}
		};	*/
		Function<Person, Integer> classifier = Person::getAge;
		Map<Integer, List<Person>> personsByAge = 
				getPersonList().stream()
				.collect(Collectors.groupingBy(classifier));
		// Key:age, Value:personList
		personsByAge.forEach(
				(age, personList) -> 
					System.out.format("age %s: %s\n", age, personList)
		);
	}

	private static void testPartitioningBy() {
		Map<Boolean, List<Person>> personsByAge = 
				getPersonList().stream()
				.collect(Collectors.partitioningBy(s -> s.age > 20));
		System.out.println("Is age > 20 ?");
		personsByAge.forEach(
			(k, v) -> System.out.println(
							k + ":\t"
							+ v.stream()
								.map(s -> s.name)
								.collect( Collectors.joining(", ") )
					)
		);
	}
	

	private static void testMappingFlatMapping() {
		List<Blog> blogs = Blog.getBlogs();

		// 1. groupingBy
		Map<String, List<Blog>> authorByName 
			= blogs.stream().collect(
				Collectors.groupingBy(
					Blog::getAuthorName, 
					Collectors.toList()));
		System.out.println(authorByName);

		// 2. groupingBy + mapping
		Map<String, List<List<String>>> authorComments1 
			= blogs.stream().collect(
				Collectors.groupingBy(
					Blog::getAuthorName, 
					Collectors.mapping(Blog::getComments,
											Collectors.toList())));
/*
		Map<String, List<Blog>> authorComments1_ 
			= blogs.stream().collect(
				Collectors.groupingBy(
					Blog::getAuthorName, 
					Collectors.mapping(blog -> blog,
											Collectors.toList())));
*/		
		System.out.println(authorComments1);
		
		// 3. groupingBy + flatMapping
		Map<String, List<String>> authorComments2 
			= blogs.stream().collect(
				Collectors.groupingBy(
					Blog::getAuthorName,
					Collectors.flatMapping(blog -> blog.getComments().stream(), 
											Collectors.toList())));
		System.out.println(authorComments2);
	}
	

	private static void testFiltering1() {
		List<Person> persons = getPersonList();

	//  .stream().filter()	
		List<Person> filter 
			= persons.stream()
				.filter(p -> p.getAge() > 20)
				.collect(
					Collectors.toList());
		System.out.println(filter);
		
	//  .stream().collect(Collectors.filtering())	
		List<Person> filtering 
			= persons.stream()
				.collect(
					Collectors.filtering(
								p -> p.getAge() > 20, 
								Collectors.toList()));
		System.out.println(filtering);

	}


	private static void testFiltering2() {
		List<Person> persons = getPersonList();

	// 	.stream().filter().collect(Collectors.groupingBy())
		Map<String, Long> filter4Grouping 
			= persons.stream()
				.filter(p -> p.getAge() > 20)
				.collect(
					Collectors.groupingBy(
						Person::getName, 
						Collectors.counting()));
		System.out.println(filter4Grouping);

	//  .stream().collect(Collectors.groupingBy(Collectors.filtering()))
		Map<String, Long> filtering4Grouping 
			= persons.stream()
				.collect(
					Collectors.groupingBy(
						Person::getName, 
						Collectors.filtering(
								p -> p.getAge() > 20, 
								Collectors.counting())));
		System.out.println(filtering4Grouping);
	}

}
