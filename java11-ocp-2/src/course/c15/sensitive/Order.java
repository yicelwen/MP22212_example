package course.c15.sensitive;

public class Order {
	private String item;
	private int count;

	public Order(String item, int count) {
		setItem(item);
		setCount(count);
	}
/*
	public static Order getOrder(String item, int count) {
		return new Order(item, count);
	}
*/
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
