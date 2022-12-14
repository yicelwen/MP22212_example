package course.c12.s51;

interface MyInterface {
	void myMethod();
}

class MySuper implements MyInterface {
	@Override
	public void myMethod() {
		System.out.println("from MySuper");
	}
}

class MySub extends MySuper {
	@Override
	public void myMethod() {
		System.out.println("from MySub");
	}
}

public class OverrideLab {
	public static void main(String args[]) {
		MyInterface x = new MySub();
		x.myMethod();
	}
}
