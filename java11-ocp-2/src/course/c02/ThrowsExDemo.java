package course.c02;

import java.io.*;

public class ThrowsExDemo {
	public static void readFromFile1() throws FileNotFoundException, IOException, Exception {
		try (InputStream in = new FileInputStream("a.txt")) {
			// codes go here
		}
	}

	public static void readFromFile2() throws Exception, IOException, FileNotFoundException {
		try (InputStream in = new FileInputStream("a.txt")) {
			// codes go here
		}
	}

	public static void main(String[] args) {
		try {
			readFromFile1();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
