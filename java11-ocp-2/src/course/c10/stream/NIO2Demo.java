package course.c10.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class NIO2Demo {

	public static void main(String[] args) throws IOException {
		testList();
		testFind();
		testWalk();
		testLines();
		testNewBufferedReader();
	}

	public static void testList() throws IOException {
		try (Stream<Path> stream = 
				Files.list(Paths.get("src/course/c10"))) {
			stream
				.filter(path -> path.toString().endsWith(".txt"))
				.forEach(System.out::println);
		}
	}

	public static void testFind() throws IOException {
		try (Stream<Path> stream = 
				Files.find(
						Paths.get("src"), 
						4,
						(path, attr) -> path.toString().endsWith(".txt"))
				) {
			stream.forEach(System.out::println);
		}
	}

	public static void testWalk() throws IOException {
		try (Stream<Path> stream = 
				Files.walk(Paths.get("dir/NIO2Demo"), 4)) {
			stream
				.filter(path -> path.toString().endsWith(".txt"))
				.forEach(System.out::println);
		}
		try (Stream<Path> stream = 
				Files.walk(Paths.get("dir/NIO2Demo"))) {
			stream
				.filter(path -> path.toString().endsWith(".txt"))
				.forEach(System.out::println);
		}
	}

	public static void testLines() throws IOException {
		try (Stream<String> stream = 
				Files.lines(Paths.get("data.txt"))) {
			stream
				.map(String::toLowerCase)
				.forEach(System.out::println);
		}
	}

	public static void testNewBufferedReader() throws IOException {
		try (BufferedReader reader = 
				Files.newBufferedReader(Paths.get("data.txt"))) {
			reader
				.lines()
				.map(String::toLowerCase)
				.forEach(System.out::println);
		}
	}
}
