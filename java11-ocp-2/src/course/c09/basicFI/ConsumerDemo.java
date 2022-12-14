package course.c09.basicFI;

import java.util.function.Consumer;

import course.c09.Person;

public class ConsumerDemo {
	public static void main(String[] args) {
		Consumer<Person> printPerson = p -> p.printPerson();
//		Consumer<Person> printPerson = Person::printPerson;
	
		/* use anonymous inner class:	
		Consumer<Person> printPerson = new Consumer<Person>() {
			public void accept(Person t) {
				p -> p.printPerson();
			}
		};	
		*/
		for (Person p: Person.createList()) {
			printPerson.accept(p);
		}
	}
}
