package course.c01;

import java.util.*;

public class TestSet {
	public static void main(String[] args) {

		Set<String> set = new TreeSet<>();

		set.add("one");
		set.add("two");
		set.add("three");
		set.add("three"); // not added, no runtime error.

		for (String item : set) {
			System.out.println("Item: " + item);
		}
		
	}
}
