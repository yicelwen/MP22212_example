package course.c04;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import static java.nio.file.FileVisitResult.*;

class Finder extends SimpleFileVisitor<Path> {
	PathMatcher matcher = 
			FileSystems.getDefault().getPathMatcher("glob:" + "*.java");
	int numMatches;

	private void find(Path file) {
		Path name = file.getFileName();
		if (name != null && matcher.matches(name)) {
			numMatches++;
			System.out.println(file);
		}
	}
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		find(file);
		return CONTINUE;
	}
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		find(dir);
		return CONTINUE;
	}
}

public class PathMatcherTest2 {
	public static void main(String[] args) {
		
		Path root = Paths.get("").toAbsolutePath();
		System.out.println("root: " +  root);
		
		Finder finder = new Finder();	//implements FileVisitor
		
		try {
			Files.walkFileTree(root, finder);
		} catch (IOException e) {
			System.out.println("Exception: " + e);
		}
		System.out.println("----\n" + finder.numMatches + " found!!");
	}
}
