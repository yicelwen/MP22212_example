package course.c03;

import java.io.Console;

public class ConsoleInput {
	public static void main(String[] args) {
		Console cons = System.console();
		boolean userValid = false;
		if (cons != null) {
			String account;
			String password;
			do {
				account = cons.readLine("%s", "Account: ");
				password = new String(cons.readPassword("%s", "Password: "));
				if (account.equals("jim") && password.equals("password")) {
					System.out.println("Correct! System quits!");
					userValid = true;
				} else {
					System.out.println("Wrong! Try again!\n");
				}
			} while (!userValid);
		}
	}
}
