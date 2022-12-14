package course.c06;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


class CallableTask implements Callable<String> {
	@Override
	public String call() throws Exception {
		Thread.sleep(20000);
		System.out.println(new Date() + ": finish job");
		return new Date() + ": done";
	}
}

public class ExecutorServiceTest {
	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		// 未接受派工，threads 在60秒 後將死亡
		
		//ExecutorService es = Executors.newFixedThreadPool(5);
		// 未接受派工，threads 不會死亡
		
		Callable<String> task = new CallableTask();
		Future<String> future = es.submit(task);
		try {
			String result = future.get();
			System.out.println(result);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
		es.shutdown();	
		System.out.println(new Date() + ": ExecutorService shutdown");
		
		try {
			es.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException ex) {
			System.out.println("Stopped waiting early");
		}
	}
}
