package course.c10.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DataSource {
	
	static List<Order> getOrdersAndItems() {
		List<Order> orders = new ArrayList<>();
		// 在 orders裡建立 3 個Order
		IntStream.range(1, 4)
			.forEach(i -> orders.add(new Order("Order_" + i)));
		// 在 orders 裡的每個 items 裡各建立 3 個 Item
		orders.forEach(
			order -> 
				IntStream
				.range(1, 4)
				.forEach(
					i -> 
						order.items.add(
							new Item("Item_" + i + " , from <" + order.name + ">")
						)
				)
		);
		return orders;
	}

}
