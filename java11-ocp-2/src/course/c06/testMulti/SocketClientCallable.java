package course.c06.testMulti;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class SocketClientCallable implements Callable<String> {
	private String host;
	private int port;
	public SocketClientCallable(String host, int port) {
		this.host = host;
		this.port = port;
	}
	@Override
	public String call() throws IOException {
		try (Socket sock = new Socket(host, port);
				Scanner scanner = new Scanner(sock.getInputStream());) {
			String feedback = scanner.next();
			return feedback;
		}
	}
}
