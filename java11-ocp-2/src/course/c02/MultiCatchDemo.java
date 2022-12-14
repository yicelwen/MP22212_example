package course.c02;

import java.io.File;
import java.io.IOException;

public class MultiCatchDemo {

	public static void main(String args[]) {
		before7();
		after7();
	}

	private static void after7() {
		try {
			createTempFile();
		} catch (IOException 
				| IllegalArgumentException 
				| ArrayIndexOutOfBoundsException 
				| SecurityException e) {
			System.out.println("Known Exception: " + e.getClass());
		} catch (Exception e) {
			System.out.println("Unexpected Execption: " + e.getClass() + " is caught!");
		}
	}

	private static void before7() {
		try {
			createTempFile();
		} catch (IOException ioe) {
			System.out.println("Known Exception: " + ioe.getClass());
		} catch (IllegalArgumentException iae) {
			System.out.println("Known Exception: " + iae.getClass());
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			System.out.println("Known Exception: " + aiobe.getClass());
		} catch (SecurityException se) {
			System.out.println("Known Exception: " + se.getClass());
		} catch (Exception e) {
			System.out.println("Unexpected Execption: " + e.getClass() + " is caught!");
		}
	}

	static void createTempFile() throws IOException {
		String path = System.getProperty("user.dir") + "/src/course/c02/temp";
		System.out.println(path);
		File f = new File(path);
		File tf = File.createTempFile("ji", null, f);
		System.out.println("Temp file name: " + tf.getPath());
		int arr[] = new int[5];
		arr[5] = 25;
	}
}
