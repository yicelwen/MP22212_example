package course.c10.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOpDemo {

	public static void main(String args[]) {
		testForEach();
		testCount();
		testSum();
		testAverage();
		testMaxMin();
	}

	@SuppressWarnings("unused")
	public static void testForEach() {
		
		Consumer<String> action0 = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		Consumer<String> action1 = t -> System.out.println(t);
		Consumer<String> action = System.out::println;

		Stream.of("Hello", "World")
		.forEach(action);
	}

	public static void testCount() {
		long cnt = Stream.of("Hello", "World").count();
		System.out.println(cnt);
		// 2
	}

	public static void testSum() {
		// Stream.of(1, 2, 3, 4).sum(); //compile error!
		//IntStream 
		int iSum = Stream.of(1, 2, 3, 4).mapToInt(i -> i).sum();
		System.out.println(iSum);
		//LongStream
		long lSum = Stream.of(1, 2, 3, 4).mapToLong(i -> i).sum();
		System.out.println(lSum);
		//DoubleStream
		double dSum = Stream.of(1, 2, 3, 4).mapToDouble(i -> i).sum();
		System.out.println(dSum);	
		//Empty Stream
		int zero = IntStream.of().sum();
		System.out.println(zero);	
	}

	public static void testAverage() {
		OptionalDouble avg = Stream.of(1, 2, 3, 4).mapToInt(i -> i).average();
		System.out.println(avg);	
		System.out.println(avg.getAsDouble());	
		
		IntStream is = Arrays.stream(new int[] {});
		OptionalDouble emptyAvg = is.average();
		System.out.println(emptyAvg);
	}
	
	
	public static void testMaxMin() {
		/*		
 		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};	*/
		// Comparator<String> comparator = (o1, o2) -> o1.compareTo(o2);
		Comparator<String> comparator = String::compareTo;
		
		Optional<String> os = Stream.of("x", "y").max(comparator);
		System.out.println(os);	
		
		List<String> list = new ArrayList<String>();
		Optional<String> empty = list.stream().max(comparator);
		System.out.println(empty);
				
		OptionalInt oi = Stream.of(1, 2, 3).mapToInt(i -> i).min();
		System.out.println(oi);	
	}



}
