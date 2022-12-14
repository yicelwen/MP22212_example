package course.c09;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name, email;
	private int age;
	public Person() {}
	public Person(String name, String email, int age) {
		this.name = name;
		this.age = age;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Name=" + name + ", Age=" + age + ", email=" + email;
	}

	public void printPerson() {
		System.out.println(this);
	}
	
	public static List<Person> createList() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Bob", "bob@x.com", 21));
		people.add(new Person("Jane", "jane@x.com", 34));
		people.add(new Person("John", "johnx@x.com", 25));
		people.add(new Person("Phil", "phil@x.com", 65));
		people.add(new Person("Betty", "betty@x.com", 55));
		return people;
	}

	public static Person[] createArray() {
		List<Person> pl = createList();
		return pl.toArray(new Person[pl.size()]);
	}
	
	// similar to Comparator method
	public static int compareName(Person a, Person b) {
		return a.getName().compareTo(b.getName());
	}
	// similar to Comparator method
	public int compareAge(Person a, Person b) {
		return Integer.valueOf(a.getAge()).compareTo(b.getAge());
	}

	
	// similar to Comparable method
	public int compareNameTo(Person a) {
		return this.getName().compareTo(a.getName());
	}
	// similar to Comparable method
	public int compareAgeTo(Person a) {
		return Integer.valueOf(this.getAge()).compareTo(a.getAge());
	}
	// similar to Comparable method
	public int compareEmailTo(Person a) {
		return this.getEmail().compareTo(a.getEmail());
	}

}
