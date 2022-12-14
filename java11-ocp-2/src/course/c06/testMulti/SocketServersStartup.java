package course.c06.testMulti;

import java.io.*;
import java.net.*;

public class SocketServersStartup {
	public static void main(String[] args) {
		for (int port = 10000; port < 10005; port++) {
			new Thread(new MySocketServer(port)).start();
		}
	}
}

class MySocketServer implements Runnable {
	int port;
	MySocketServer(int port) {
		this.port = port;
	}
	@Override
	public void run() {
		System.out.println("Server " + port + ": Listening...");
		while (true) {
			try {
				// Listen on port
				ServerSocket serverSock = new ServerSocket(port);
				// Get connection
				Socket clientSock = serverSock.accept();
				//sleep for 5 seconds
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// feedback & output
				PrintWriter pw = new PrintWriter(clientSock.getOutputStream(), true);
				pw.println("feedback_from_" + port);
				// close
				serverSock.close();
				clientSock.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

