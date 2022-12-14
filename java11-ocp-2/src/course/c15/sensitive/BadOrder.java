package course.c15.sensitive;

public class BadOrder extends Order {
	public BadOrder(String item, int count) {
		super(item, count);
	}
	public int getCount() {
		return 0;
	}
	public void setCount(int count) {
		super.setCount(0);
	}
}
