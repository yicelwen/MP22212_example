package course.c10.stream;

import java.util.ArrayList;
import java.util.List;

public class Order {
	String name;

	Order(String name) {
		this.name = name;
	}

	List<Item> items = new ArrayList<>();

	public String toString() {
		return this.name;
	}
}