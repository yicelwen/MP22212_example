package course.c05;

class InterruptedRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("Thread started");
		
		while (!Thread.interrupted()) {
			System.out.println("I am running...");
		}
		
		System.out.println("Thread finishing");
	}
}

public class InterruptThreadExample {
	public static void main(String[] args) {
		InterruptedRunnable r1 = new InterruptedRunnable();
		Thread t1 = new Thread(r1);
		t1.start();
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {}
		
		t1.interrupt();
	}
}
