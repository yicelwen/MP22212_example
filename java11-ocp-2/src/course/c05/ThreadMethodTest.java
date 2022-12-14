package course.c05;

class ThreadTest extends Thread {
	public void run() {
		try {
			System.out.println("Thread t is starting...");
			for (int i = 0; i < 3; i++) {
				Thread.sleep(1000);
				System.out.println("Thread t is running...");
			}
			System.out.println("Thread t is ending...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ThreadMethodTest {
	public static void main(String[] args) {
		System.out.println("Thread main is starting...");
		testNormal();
		testJoin();
		testDaemon();
		System.out.println("Thread main is ending...");
	}

	private static void testNormal() {
		Thread t = new ThreadTest();
		t.start();
	}

	private static void testJoin() {
		Thread t = new ThreadTest();
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	private static void testDaemon() {
		Thread t = new ThreadTest();
		t.setDaemon(true);	
		t.start();		
		//t.setDaemon(true);	//java.lang.IllegalThreadStateException
	}
}
