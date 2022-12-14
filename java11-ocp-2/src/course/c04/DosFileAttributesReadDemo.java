package course.c04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;

public class DosFileAttributesReadDemo {
	public static void main(String[] args) throws IOException {
		Path p = Paths.get("dir/c04/attributeTest.txt").toAbsolutePath();
		DosFileAttributes attrs = Files.readAttributes(p, DosFileAttributes.class);

		// basic
		FileTime creation = attrs.creationTime();
		FileTime modified = attrs.lastModifiedTime();
		FileTime lastAccess = attrs.lastAccessTime();
		if (!attrs.isDirectory()) {
			long size = attrs.size();
		}
		boolean isDirectory = attrs.isDirectory();
		boolean isRegularFile = attrs.isRegularFile();
		boolean isSymbolicLink = attrs.isSymbolicLink();
		boolean isOther = attrs.isOther();
		
		// only for DOS
		boolean archive = attrs.isArchive();
		boolean hidden = attrs.isHidden();
		boolean readOnly = attrs.isReadOnly();
		boolean systemFile = attrs.isSystem();
	}
}
