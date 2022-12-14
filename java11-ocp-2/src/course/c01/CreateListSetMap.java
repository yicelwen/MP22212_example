package course.c01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreateListSetMap {

	private static void createImmutablesByOf() {

		// List.of()

		List<String> list1 = List.of("i1", "i2", "i3");
		try {
			list1.add("i4");
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> list2 = new ArrayList<>(list1);
		list2.add("i4");
		System.out.println(list2);

		// Set.of()

		Set<String> set1 = Set.of("i1", "i2", "i3");
		try {
			set1.add("i4");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Set<String> set2 = new HashSet<>(set1);
		set2.add("i4");
		System.out.println(set2);

		// Map.of()

		Map<String, Employee> map1 = 
				Map.of("jim", new Employee("jim"), "duke", new Employee("duke"));
		try {
			map1.put("bill", new Employee("bill"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Employee> map2 = new HashMap<>(map1);
		map2.put("bill", new Employee("bill"));
		System.out.println(map2);

	}

	private static void createImmutablesByCopyOf() {

		// List.copyOf()

		List<String> list1 = List.of("i1", "i2", "i3");
		List<String> list2 = List.copyOf(list1);
		try {
			list2.add("i4");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Set.copyOf()

		Set<String> set1 = Set.of("i1", "i2", "i3");
		Set<String> set2 = Set.copyOf(set1);
		try {
			set2.add("i4");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Map.copyOf()

		Map<String, Employee> map1 = 
				Map.of("jim", new Employee("jim"), "duke", new Employee("duke"));
		Map<String, Employee> map2 = Map.copyOf(map1);
		try {
			map2.put("bill", new Employee("bill"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void createList() {
		List<String> list1 = Arrays.asList("i1", "i2", "i3");
		try {
			list1.set(0, "ii1");
			System.out.println(list1);
			list1.remove(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> list2 = new ArrayList<>(list1);
		list2.remove(0);
		System.out.println(list2);
	}

	public static void main(String[] args) {

		createImmutablesByOf();

		createImmutablesByCopyOf();

		createList();

	}

}

class Employee {
	String name;
	public Employee(String name) {
		this.name = name;
	}
}
