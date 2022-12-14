package course.c03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyByteStream {
	public static void main(String[] args) {
		String source = "";
		String target = "";
		byte[] b = new byte[128];
		int bLen = b.length;
		try (FileInputStream fis = new FileInputStream(source); 
				FileOutputStream fos = new FileOutputStream(target)) {
			System.out.println("Need to copy bytes: " + fis.available());
			int read = 0;
			while ((read = fis.read(b)) != -1) {
				if (read < bLen) {
					fos.write(b, 0, read);
				} else {
					fos.write(b);
				}
			}
		} catch (FileNotFoundException fne) {
			fne.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
