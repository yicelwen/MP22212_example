package course.c01;

import java.util.*;

public class TestList {

	private static void withoutGeneric() {
		List list = new ArrayList(2);

		list.add(Integer.valueOf(1));
		list.add(Integer.valueOf(2));
		list.add("I am a string!");

		Iterator elements = list.iterator();
		while (elements.hasNext()) {
			Integer partNumberObject = (Integer) (elements.next()); // Runtime error!

			int partNumber = partNumberObject.intValue();
			System.out.println("element: " + partNumber);
		}

	}

	private static void withGeneric() {
		List<Integer> list = new ArrayList<>(2);

		list.add(Integer.valueOf(1));
		list.add(Integer.valueOf(2));
		// list.add( “I am a string!“ ); //Compile Error!!

		Iterator<Integer> elements = list.iterator();
		while (elements.hasNext()) {
			Integer partNumberObject = elements.next(); // Runtime is safe!!

			int partNumber = partNumberObject.intValue();
			System.out.println("Part number: " + partNumber);
		}

	}

	public static void main(String args[]) {
		withoutGeneric();
		withGeneric();
	}
}
