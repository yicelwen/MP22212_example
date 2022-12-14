package course.c05;

class MyRunnable implements Runnable {
	public volatile boolean running = true;
	@Override
	public void run() {
		System.out.println("Thread started");
		while (running) {
			// ...
		}
		System.out.println("Thread finishing");
	}
}

public class StopThreadExample {
	public static void main(String[] args) {
		MyRunnable r1 = new MyRunnable();
		Thread t1 = new Thread(r1);
		t1.start();
		// ...
		r1.running = false;		//馬上停止執行緒執行!
	}
}
