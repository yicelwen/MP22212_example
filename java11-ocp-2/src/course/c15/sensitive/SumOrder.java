package course.c15.sensitive;

import java.util.Arrays;
import java.util.List;

public class SumOrder {

	public static void main(String[] args) {
		normal();
		attack();
	}

	private static void attack() {
		Order o1 = new BadOrder("A", 100);
		Order o2 = new BadOrder("B", 200);
		System.out.println("Tampered Result: " + total(Arrays.asList(o1, o2)));
	}

	private static void normal() {
		Order o1 = new Order("A", 100);
		Order o2 = new Order("B", 200);
		System.out.println("Correct Result: " + total(Arrays.asList(o1, o2)));
	}

	private static int total(List<Order> orders) {
		return orders.stream().mapToInt(Order::getCount).sum();
	}

}
