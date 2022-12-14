package course.c06.testMulti;

import java.io.IOException;

import java.net.Socket;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;
import static java.lang.System.out;

public class SingleThreadTest {
	public static void main(String[] args) {
		out.println("SingleThread starts at: " + new Date());
		String host = "localhost";
		for (int port = 10000; port < 10005; port++) {
			try (Socket sock = new Socket(host, port);
					Scanner scanner = new Scanner(sock.getInputStream());) {
				String feedback = scanner.next();
				out.println("Call " + host + ":" + port +
						 ", and get: " + feedback + " at " + new Date());
			} catch (NoSuchElementException | IOException ex) {
				out.println("Error talking to " + host + ":" + port);
			}
		}
	}
}
