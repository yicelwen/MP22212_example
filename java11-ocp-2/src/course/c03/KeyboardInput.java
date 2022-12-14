package course.c03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInput {
	public static void main(String[] args) {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			String s = "";
			while (s != null) {
				System.out.print("Type abc to quit:");
				s = in.readLine();
				if (s != null) {
					s = s.trim();
				}
				System.out.println("Read: " + s);
				if (s.equals("abc")) {
					System.out.println("=== Right answer! Quit! ===");
					System.exit(0);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
