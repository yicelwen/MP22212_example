package course.c06;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
	public static void main(String[] args) {
		AtomicInteger ai = new AtomicInteger(5);
		if (ai.compareAndSet(5, 42)) {
			System.out.println("after compareAndSet(): " + ai);
		}
		ai.getAndIncrement();
		System.out.println("after getAndIncrement(): " + ai);
	}
}
