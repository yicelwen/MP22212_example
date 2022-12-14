package course.c01;

class UseString {
	private String message;

	public void add(String message) {
		this.message = message;
	}

	public String get() {
		return this.message;
	}
}

class Shirt {
}

class UseShirt {
	private Shirt shirt;

	public void add(Shirt shirt) {
		this.shirt = shirt;
	}

	public Shirt get() {
		return this.shirt;
	}
}

class UseAny<T> {
	private T t;

	public void add(T t) {
		this.t = t;
	}

	public T get() {
		return this.t;
	}
}

public class UseGeneric {

	public static void main(String[] args) {
		// 使用一般方式：
		UseShirt shirt1 = new UseShirt();
		UseString msg1 = new UseString();
		msg1.add("test generic");
		// 使用泛型：
		UseAny<Shirt> shirt2 = new UseAny<Shirt>();
		UseAny<String> msg2 = new UseAny<String>();
		msg2.add("test generic");

	}

}
