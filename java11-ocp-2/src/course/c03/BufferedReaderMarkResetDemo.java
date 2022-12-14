package course.c03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderMarkResetDemo {
	
	public static void main(String[] args) throws Exception {

		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {
			
			System.out.println("Is markSupported on... ");
			
			String f = System.getProperty("user.dir") + "\\src\\course\\c03\\test.txt";
			is = new FileInputStream(f);
			System.out.println("FileInputStream? " + is.markSupported());

			// create new input stream reader
			isr = new InputStreamReader(is);
			System.out.println("InputStreamReader? " + isr.markSupported());

			// create new buffered reader
			br = new BufferedReader(isr);
			System.out.println("BufferedReader? " + br.markSupported());
			
			System.out.println("----------------------------");

			// reads and prints BufferedReader
			System.out.println((char) br.read());
			System.out.println((char) br.read());
			
			// mark invoked at this position, input parameter looks does not make sense!!
			br.mark(0);
			System.err.println("mark() invoked");
			System.out.println((char) br.read());
			System.out.println((char) br.read());

			// reset() repositioned the stream to the mark
			br.reset();
			System.out.println("reset() invoked");
			System.out.println((char) br.read());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null)
				is.close();
			if (isr != null)
				isr.close();
			if (br != null)
				br.close();
		}
	}
}
