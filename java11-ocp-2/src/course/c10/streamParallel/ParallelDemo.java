package course.c10.streamParallel;

import java.util.stream.IntStream;

public class ParallelDemo {

	public static void testReduceInSequential() {
		int result = 
			IntStream
				.rangeClosed(1, 4)
				.reduce(0, (sum, element) -> sum + element);
		System.out.println("Result = " + result);
	}

	public static void testReduceWithCompactly() {
		int sum = 
				IntStream
					.rangeClosed(1, 4)
					.reduce(0, Integer::sum);
		System.out.println("sum = " + sum);
		int max = 
				IntStream
					.rangeClosed(1, 4)
					.reduce(0, Integer::max);
		System.out.println("max = " + max);
		int min = 
				IntStream
					.rangeClosed(1, 4)
					.reduce(0, Integer::min);
		System.out.println("min = " + min);
	}
	
	public static void testReduceInParallel() {
		int result =
			IntStream
				.rangeClosed(1, 8)
				.parallel()
				.reduce(0, (sum, element) -> sum + element);
		System.out.println("Result = " + result);
	}

	public static void main(String[] args) {
		testReduceInSequential();
		testReduceInParallel();
		testReduceWithCompactly();
	}

}
