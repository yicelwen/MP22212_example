package course.c04;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.regex.PatternSyntaxException;

public class FilesCopyTest {

	public static void main(String[] args) throws IOException {
		init("copyTo");

		testCopy();

	}

	private static void testCopy() throws IOException {
		Path pFromBasic = Paths.get("dir/c04/from").toAbsolutePath();
		Path pTo = Paths.get("dir/c04/copyTo/").toAbsolutePath();

		String target = null;

		// try file copy
		target = "fileFrom.txt";
		Files.copy(pFromBasic.resolve(target), pTo.resolve(target));
		try {
			Files.copy(pFromBasic.resolve(target), pTo.resolve(target));
			// java.nio.file.FileAlreadyExistsException
		} catch (Exception e) {
			e.printStackTrace();
		}
		Files.copy(pFromBasic.resolve(target), pTo.resolve(target), StandardCopyOption.REPLACE_EXISTING);
		clean(pTo);

		// try directory copy, without files in it
		target = "dirFrom";
		Files.copy(pFromBasic.resolve(target), pTo.resolve(target));
		clean(pTo);

		// try directory copy, with files in it
		target = "dirFromWithFile";
		Files.copy(pFromBasic.resolve(target), pTo.resolve(target));
		// inner files are excluded
		clean(pTo);

		// try symbolicLink copy
		target = "fileLink.sl";

		Files.copy(pFromBasic.resolve(target), pTo.resolve(target));
		// default will copy the linked file
		clean(pTo);

		Files.copy(pFromBasic.resolve(target), pTo.resolve(target), LinkOption.NOFOLLOW_LINKS);
		clean(pTo);

		Files.copy(pFromBasic.resolve(target), pTo.resolve(target), StandardCopyOption.REPLACE_EXISTING);
		clean(pTo);

		// try short-cut copy
		target = "fileLink.sc.lnk";
		try {
			Files.copy(pFromBasic.resolve(target), pTo.resolve(target));
		} catch (Exception e) {
			e.printStackTrace();
		}
		clean(pTo);

		// try file copy with attributes
		target = "fileFrom.txt";
		Files.copy(pFromBasic.resolve(target), pTo.resolve(target));
		clean(pTo);
		Files.copy(pFromBasic.resolve(target), pTo.resolve(target), StandardCopyOption.COPY_ATTRIBUTES);
		clean(pTo);
	}

	private static void clean(Path dir) {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*")) {
			for (Path file : stream) {
				// System.out.println("Try to delete " + file.getFileName());
				Files.deleteIfExists(file);
			}
		} catch (PatternSyntaxException | DirectoryIteratorException | IOException x) {
			System.err.println(x);
		}
	}

	private static void init(String type) throws IOException {

		Path pFrom = Paths.get("dir/c04/from").toAbsolutePath();
		Files.walkFileTree(pFrom, new FileRemoveVisitor());
		Files.createDirectories(pFrom);

		Path pTo = Paths.get("dir/c04/" + type + "/").toAbsolutePath();
		Files.walkFileTree(pTo, new FileRemoveVisitor());
		Files.createDirectories(pTo);

		Path pFromOri = Paths.get("dir/c04/from_ori").toAbsolutePath();
		Files.walkFileTree(pFromOri, new FileCopyVisitor(pFrom));

	}

}
