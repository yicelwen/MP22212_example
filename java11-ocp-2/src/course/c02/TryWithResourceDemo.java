package course.c02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TryWithResourceDemo {
	public static void main(String[] args) {
		System.out.println("Opening a file...");
		try (InputStream in = new FileInputStream("lostFile.txt")) {
			System.out.println("File is opened");
			int data = in.read();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
