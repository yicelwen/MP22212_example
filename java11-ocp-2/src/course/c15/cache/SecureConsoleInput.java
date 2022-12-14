package course.c15.cache;

import java.io.Console;
import java.util.Arrays;

public class SecureConsoleInput {
	public static void main(String[] args) {
		Console cons = System.console();
		boolean userValid = false;
		char[] ans = new char[] { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' };
		if (cons != null) {
			do {
				String account = cons.readLine("%s", "Input account: ");
				char[] password = cons.readPassword("%s", "Input password: ");
				if (account.equals("jim") && Arrays.equals(password, ans)) {
					System.out.println("Correct! System quits!");
					userValid = true;
					Arrays.fill(password, 'x');
					ans = null;
					// System.out.println(password);
				} else {
					System.out.println("Wrong! Try again!\n");
				}
			} while (!userValid);
		}
	}
}
