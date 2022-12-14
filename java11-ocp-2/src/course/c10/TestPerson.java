package course.c10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestPerson {

	public static void main(String[] args) {
		test4();
	}
	
	public static List<Person> createPersonList() {
		List<Person> people = new ArrayList<>();
		people.add(
			new Person.Builder()
			.name("Bob")
			.age(21)
			.email("bob@x.com")
			.build()	
		);
		people.add(
			new Person.Builder()
			.name("Jane")
			.age(25)
			.email("jane@x.com")
			.build()
		);
		people.add(new Person.Builder()
			.name("John").age(25).email("johnx.com").build());
		people.add(new Person.Builder()
			.name("Phil").age(55).email("phil@x.com").build());
		people.add(new Person.Builder()
			.name("Betty").age(85).email("betty@x.com").build());
		return people;
	}

	public static void test1() {
		List<Person> pl = createPersonList();
		pl.forEach(p -> System.out.println(p));
	}
	
	public static void test2() {
		List<Person> pl = createPersonList();
		pl.stream()
			.filter(p -> p.getAge() >= 23 && p.getAge() <= 65)
			.forEach(p -> System.out.println(p));
	}
	
	public static void test3() {
		List<Person> pl = createPersonList();
		Predicate<Person> criteria = p -> p.getAge() >= 23 && p.getAge() <= 65;
		Consumer<Person> action = p -> System.out.println(p);
		pl.stream()
			.filter(criteria)
			.forEach(action);
	}
	
	public static void test4() {
		List<Person> pl = createPersonList();
		pl.stream()
			.filter(p -> p.getAge() >= 23 && p.getAge() <= 65)
			.filter(p -> p.getEmail().startsWith("j"))
			.forEach(Person::printPerson);
	}
	
	public static void test5() {
		List<Person> pl = createPersonList();
		pl.stream()
			.filter(p -> p.getAge() >= 23 && 
							p.getAge() <= 65 && 
							p.getEmail().startsWith("j"))
			.forEach(Person::printPerson);
	}

}
