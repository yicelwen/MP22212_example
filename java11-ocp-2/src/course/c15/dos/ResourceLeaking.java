package course.c15.dos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourceLeaking {

	private static long countLinesWithoutCloseResource(Path path) throws IOException {
		return Files.lines(path).count();
	}

	private static long countLinesAndCloseResource(Path path) throws IOException {
		try (var stream = Files.lines(path)) {
			return stream.count();
		}
	}

	private static void transformWithoutCheckSize(Path in, Path out) throws IOException {
		var list = Files.readAllLines(in);
		list.removeIf(s -> s.trim().isBlank());
		Files.write(out, list);
	}

	private static void transformAfterCheckSize(Path in, Path out) throws IOException {
		long max = 1024 * 1024;
		long start = System.currentTimeMillis();
		long size = Files.size(in);
		long finish = System.currentTimeMillis();
		if (size < max) {
			var list = Files.readAllLines(in);
			list.removeIf(s -> s.trim().isBlank());
			Files.write(out, list);
		} else {
			throw new RuntimeException(
					String.format("file size %d(MB) exceeds 1(MB), check time elapsed = %d(ms)", size / 1204 / 1024, finish - start));
		}
	}

	public static void main(String args[]) throws IOException {
		Path in = Paths.get("src/course/c15/dos/in.txt");
		System.out.println(countLinesWithoutCloseResource(in));
		System.out.println(countLinesAndCloseResource(in));

		Path out = Paths.get("src/course/c15/dos/out.txt");
		transformAfterCheckSize(in, out);
		System.out.println(countLinesAndCloseResource(out));		
	}

}
