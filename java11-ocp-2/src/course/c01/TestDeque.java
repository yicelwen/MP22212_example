package course.c01;

import java.util.ArrayDeque;
import java.util.Deque;

public class TestDeque {

	public static void testStack(Deque<String> stack) {
		stack.push("one");
		stack.push("two");
		stack.push("three");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	public static void testQueue(Deque<String> queue) {
		queue.add("one");
		queue.add("two");
		queue.add("three");
		int size = queue.size() - 1;
		while (size >= 0) {
			System.out.println(queue.remove());
			size--;
		}

	}

	public static void main(String[] args) {
		Deque<String> deque = new ArrayDeque<>();
		System.out.println("--- Stack Out ---");
		testStack(deque);
		System.out.println("--- Queue Out ---");
		testQueue(deque);
	}
}