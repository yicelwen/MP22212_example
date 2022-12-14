package course.c09.advanceFI;

import java.util.List;
import java.util.function.BiPredicate;

import course.c09.Person;

public class BiPredicateDemo {
	public static void main(String[] args) {
		List<Person> pl = Person.createList();
		Person first = pl.get(0);
		String testName = "john";
		BiPredicate<Person, String> nameBiPred = 
				(p, s) -> p.getName().equalsIgnoreCase(s);
		/* use anonymous inner class:	
		BiPredicate<Person, String> nameBiPred = 
					new BiPredicate<Person, String>() {
						public boolean test(Person p, String s) {
							return p.getName().equalsIgnoreCase(s);
						}
					}
		;	
		*/
		System.out.println("Is the first john? " 
							+ nameBiPred.test(first, testName));
	}
}
