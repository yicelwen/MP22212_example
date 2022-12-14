package course.c09;

import java.util.ArrayList;
import java.util.List;

class AA {
}

class A extends AA {
}

class B extends A {
}

class C extends A {
}

@SuppressWarnings("unused")
public class WildcardTest {

	public static void main(String[] args) {
		List<A> listA = new ArrayList<A>();
		listA.add(new A());
		listA.add(new B());
		listA.add(new C());
		List<B> listB = new ArrayList<B>();
		listA.add(new B());

		List<?> listUknown0 = new ArrayList<A>();

		List<? extends A> listUknown1 = new ArrayList<A>(); // 內容必須是A或A的子類別
		List<? extends A> listUknown11 = new ArrayList<B>(); // 內容必須是A或A的子類別

		List<? super A> listUknown2 = new ArrayList<A>(); // 內容必須是A或A的父類別
		List<? super A> listUknown21 = new ArrayList<AA>(); // 內容必須是A或A的父類別
		// List<? super A> listUknown22 = new ArrayList<B>(); // 內容必須是A或A的父類別
	}

	private static void processElements(List<?> elements) {
		// elements.add(new A());		// compile error!
		// elements.add(new B());		// compile error!
		// elements.add(new C());		// compile error!
		// elements.add(new Object());	// compile error!
		for (Object o : elements) {
			System.out.println(o);
		}
	}
	private static void testProcessElements() {
		List<A> listA = new ArrayList<A>();
		processElements(listA);
		List<B> listB = new ArrayList<B>();
		processElements(listA);
		List<C> listC = new ArrayList<C>();
		processElements(listA);
	}

	private static void processExtendsElements(List<? extends A> list) {
		// elements.add(new A());		// compile error!
		// elements.add(new B());		// compile error!
		// elements.add(new C());		// compile error!
		// elements.add(new Object());	// compile error!
		for (A a : list) {
			System.out.println(a.getClass().getName());
		}
	}
	private static void testProcessExtendsElements() {
		List<A> listA = new ArrayList<A>();
		processExtendsElements(listA);

		List<B> listB = new ArrayList<B>();
		processExtendsElements(listB);

		List<C> listC = new ArrayList<C>();
		processExtendsElements(listC);
	}

	public static void insertElements(List<? super A> list) {
		list.add(new A());
		list.add(new B());
		list.add(new C());
		/* compile error! 
		for (A a : list) {	
			System.out.println(a.getClass().getName());
		}*/
		Object object = list.get(0);
	}

	private static void testInsertElements() {
		List<A> listA = new ArrayList<A>();
		insertElements(listA);
		
		List<AA> listAA = new ArrayList<AA>();
		insertElements(listAA);

		List<Object> listObject = new ArrayList<Object>();
		insertElements(listObject);
	}
}
