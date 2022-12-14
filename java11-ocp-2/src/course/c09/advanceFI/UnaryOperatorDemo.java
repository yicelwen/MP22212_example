package course.c09.advanceFI;

import java.util.List;
import java.util.function.UnaryOperator;

import course.c09.Person;


public class UnaryOperatorDemo {
	public static void main(String[] args) {
		List<Person> pl = Person.createList();
		Person first = pl.get(0);
		UnaryOperator<String> unaryStr = s -> s.toUpperCase();
		/* use anonymous inner class:
		UnaryOperator<String> unaryStr = new UnaryOperator<String>() {
			public String apply(String s) {
				return s.toUpperCase();
			}
		};	
		*/
		System.out.println("Before: " + first.getName());
		System.out.println("After: " + unaryStr.apply(first.getName()));
	}
}
