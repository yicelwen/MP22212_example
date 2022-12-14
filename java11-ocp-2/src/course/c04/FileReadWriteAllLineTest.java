package course.c04;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
//import static java.nio.file.StandardOpenOption.*;
import java.util.List;

public class FileReadWriteAllLineTest {
	public static void main(String[] args) throws IOException {

		Path source = Paths.get("dir/c04/file.txt").toAbsolutePath();
		Charset cs = Charset.defaultCharset();
		List<String> lines = Files.readAllLines(source, cs);

		Path target = Paths.get("dir/c04/file2.txt").toAbsolutePath();
		Files.write(target, lines, cs, 
				StandardOpenOption.CREATE, 
				StandardOpenOption.TRUNCATE_EXISTING,
				StandardOpenOption.WRITE);
		
		System.out.println("done...");

	}

}
