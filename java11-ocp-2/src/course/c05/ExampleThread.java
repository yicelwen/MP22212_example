package course.c05;

public class ExampleThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("i:" + i);
		}
	}

	public static void main(String[] args) {
		Thread t1 = new ExampleThread();
		t1.start();
	}

}
/*
class ExampleRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("i:" + i);
		}
	}
}
*/