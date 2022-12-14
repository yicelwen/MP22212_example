package course.c09.basicFI;


import java.util.function.Function;

import course.c09.Person;

public class FunctionDemo {
	public static void main(String[] args) {
		Function<Person, String> getNameFromPerson = p -> p.getName();
		/* use anonymous inner class:	
		Function<Person, String> getNameFromPerson = 
				new Function<Person, String>() {
					public String apply(Person p) {
						return p.getName();
				}
		};	
		*/
		for (Person p: Person.createList()) {
			System.out.println(getNameFromPerson.apply(p));
		}
	}
}
