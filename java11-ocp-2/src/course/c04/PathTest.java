package course.c04;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	private static void testSplit() {
		Path p1 = Paths.get("D:/Temp/Foo/file1.txt");
		System.out.format("getFileName: %s%n", p1.getFileName());
		System.out.format("getParent: %s%n", p1.getParent());
		System.out.format("getNameCount: %d%n", p1.getNameCount());
		System.out.format("getRoot: %s%n", p1.getRoot());
		System.out.format("isAbsolute: %b%n", p1.isAbsolute());
		System.out.format("toAbsolutePath: %s%n", p1.toAbsolutePath());
		System.out.format("toURI: %s%n", p1.toUri());
	}

	private static void testNormalize() {
		Path p1 = Paths.get("/home/./clarence/foo");
		p1 = p1.normalize();
		System.out.println(p1);
		Path p2 = Paths.get("/home/peter/../clarence/foo");
		p2 = p1.normalize();
		System.out.println(p2);
	}

	private static void testSubPath() {
		Path p1 = Paths.get("D:/Temp/foo/bar");
		p1.subpath(1, 3);
		System.out.println(p1);
		p1 = p1.subpath(1, 3);
		System.out.println(p1);
	}

	private static void testResolve() {
		String p = "/home/clarence/foo";
		Path p1 = Paths.get(p).resolve("bar");
		System.out.println(p1);
		Path p2 = Paths.get(p).resolve("/home/clarence");
		System.out.println(p2);
	}

	private static void testRelativize() {
		Path p1 = Paths.get("peter");
		Path p2 = Paths.get("jim");
		Path p1Top2 = p1.relativize(p2); // 由 p1 到 p2 的走法
		System.out.println(p1Top2);
		Path p2Top1 = p2.relativize(p1); // 由 p2 到 p1 的走法
		System.out.println(p2Top1);
	}
	


	public static void main(String[] args) {
		testSplit();
		testNormalize();
		testSubPath();
		testResolve();
		testRelativize();

	}

}
