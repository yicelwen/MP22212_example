package course.c04;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.PatternSyntaxException;

public class DirectoryStreamTest {
	public static void main(String[] args) {
		Path dir = Paths.get("D:/");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*")) {
			for (Path file : stream) {
				System.out.println(file.getFileName());
			}
		} catch (PatternSyntaxException | DirectoryIteratorException | IOException x) {
			System.err.println(x);
		}
	}
}
