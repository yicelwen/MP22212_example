package course.c05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Item {
	String desc() {
		return "...";
	}
}

public class ShopingCart {
	private List<Item> cart = new ArrayList<>();

	public synchronized void addItem(Item item) {
		cart.add(item);
	}

	public synchronized void removeItem(int index) {
		cart.remove(index);
	}

	public synchronized String summary() {
		StringBuilder note = new StringBuilder();
		Iterator<Item> iter = cart.iterator();
		while (iter.hasNext()) {
			Item i = iter.next();
			note.append("Item:" + i.desc() + "\n");
		}
		return note.toString();
	}
}
