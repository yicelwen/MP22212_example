package course.c04;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyInputStreamTest {
	public static void main(String[] args) throws IOException {
		Path to = Paths.get("dir/c04/Java_logo.png").toAbsolutePath();
		URL url = URI.create("https://upload.wikimedia.org/wikipedia/zh/8/88/Java_logo.png").toURL();
		try (InputStream from = url.openStream()) {
			Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Copy finished...");
		}
	}
}
