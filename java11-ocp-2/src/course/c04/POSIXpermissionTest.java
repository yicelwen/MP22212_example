package course.c04;

import java.util.Set;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;

public class POSIXpermissionTest {

	public static void main(String[] args) {
		boolean isPOSIX = false;
		Set<String> views = FileSystems.getDefault().supportedFileAttributeViews();
		for (String s : views) {
			System.out.println(s);
			if (s.equals("posix"))
				isPOSIX = true;
		}
		if (isPOSIX) {
			Path p = Paths.get(args[0]);
			Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-x---");
			FileAttribute<Set<PosixFilePermission>> attrs = PosixFilePermissions.asFileAttribute(perms);
			try {
				Files.createFile(p, attrs);
			} catch (FileAlreadyExistsException f) {
				f.printStackTrace();
			} catch (IOException i) {
				i.printStackTrace();
			}
		}
	}

}
