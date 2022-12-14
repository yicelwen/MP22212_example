package course.c03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharStream {
	public static void main(String[] args) {
		String source = "";
		String target = "";
		char[] c = new char[128];
		int cLen = c.length;
		try (FileReader fr = new FileReader(source); 
				FileWriter fw = new FileWriter(target)) {
			int read = 0;
			while ((read = fr.read(c)) != -1) {
				if (read < cLen) {
					fw.write(c, 0, read);
				} else {
					fw.write(c);
				}
			}
		} catch (FileNotFoundException fne) {
			fne.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
