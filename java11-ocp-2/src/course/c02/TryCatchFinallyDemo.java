package course.c02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TryCatchFinallyDemo {
	public static void main(String[] args) {
		InputStream in = null;
		try {
			System.out.println("Opening a file...");
			in = new FileInputStream("lostFile.txt");
			System.out.println("File is opened");
			int data = in.read();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();	// try to close file
			} catch (IOException e) {
				System.out.println("Failed to close file");
			}
		}

	}
}
