package course.c15.injection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CommandInjectionLab {
	public static void main(String[] args) throws IOException {
		try (BufferedReader in = 
				new BufferedReader(new InputStreamReader(System.in))) {
			String s = "";
			while (s != null) {
				System.out.println("give folder name:");
				s = in.readLine();
				if (s != null) {
					s = s.trim();
					if (s.equals("exit")) {
						System.out.println("=== Quit! ===");
						System.exit(0);
					}
					vulnerable(s);
				//	invulnerable(s);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void vulnerable(String dirName) throws IOException {
		Path path = Paths.get("c15Lab/log/common/").resolve(dirName);
		try (Stream<Path> stream = Files.walk(path)) {
			stream
				.filter(p -> p.toString().endsWith(".txt"))
				.forEach(System.out::println);
		}
	}

	private static void invulnerable(String dirName) throws IOException {
		if (!(dirName.equalsIgnoreCase("module1") || dirName.equalsIgnoreCase("module2"))) {
			System.out.println("=== illegal input & terminate! ===");
			System.exit(0);
		}
		Path path = Paths.get("c15Lab/log/common/").resolve(dirName);
		try (Stream<Path> stream = Files.walk(path)) {
			stream
				.filter(p -> p.toString().endsWith(".txt"))
				.forEach(System.out::println);
		}
	}

}
