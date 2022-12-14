package course.c06.testMulti;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MultiThreadTest {
	public static void main(String[] args) {
		System.out.println("MultiThreadTest starts at: " + new Date());
		
		ExecutorService es = Executors.newCachedThreadPool();
		String host = "localhost";
		
		Map<Integer, Future<String>> callables = new HashMap<>();
		// loop to create and submit a bunch of Callable instances
		for (int port = 10000; port < 10005; port++) {
			SocketClientCallable callable = new SocketClientCallable(host, port);
			Future<String> future = es.submit(callable);
			callables.put(port, future);
		}
		
		//shutdown ExecutorService
		es.shutdown();
		try {
			es.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException ex) {
			System.out.println("Stopped waiting early");
		}

		// get result
		for (Integer port : callables.keySet()) {
			Future<String> future = callables.get(port);
			try {
				String feedback = future.get();
				System.out.println("Call " + host + ":" + port + ", and get: " + feedback + " at " + new Date());
			} catch (ExecutionException | InterruptedException ex) {
				System.out.println("Error talking to " + host + ":" + port);
			}
		}
	}
}
