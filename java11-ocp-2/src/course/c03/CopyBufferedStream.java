package course.c03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyBufferedStream {
	public static void main(String[] args) {
		String source = "";
		String target = "";
		try (BufferedReader in = new BufferedReader(new FileReader(source));
				BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
			String line = "";
			while ((line = in.readLine()) != null) {
				out.write(line);
				out.newLine();
			}
		} catch (FileNotFoundException fne) {
			fne.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
