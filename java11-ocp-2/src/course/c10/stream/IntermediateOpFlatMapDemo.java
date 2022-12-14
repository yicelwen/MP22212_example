package course.c10.stream;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class IntermediateOpFlatMapDemo {

	public static void main(String[] args) throws IOException {
		flatMapDemo1();
		flatMapDemo2();
	}
	
	public static void flatMapDemo1() {	
		long qty =
			DataSource.getOrdersAndItems().stream()	
				//.peek(System.out::println)
				.flatMap(order -> order.items.stream())			
				//.peek(System.out::println)
				.count();
		System.out.println(qty);
	}
	
	
	public static void flatMapDemo2() throws IOException {
		Path p = Paths.get("src/course/c10/stream/flatMap.txt")
				.toAbsolutePath();
		/*
		Function<String, Stream<String>> mapper = 
				new Function<String, Stream<String>>() {
					public Stream<String> apply(String line) {
						return Stream.of(line.split(" "));
					}
		};	*/
		long matches = 
				Files.lines(p)		// Stream<String>
				//.peek(System.out::println)
				.flatMap(line -> Stream.of(line.split(" ")))	// Stream<String>
				//.peek(System.out::println)
				.filter(word -> word.contains("book"))		// Stream<String> 
				//.peek(System.out::println)
				.count();

		System.out.println("# of Matches: " + matches);
	}


	
}
