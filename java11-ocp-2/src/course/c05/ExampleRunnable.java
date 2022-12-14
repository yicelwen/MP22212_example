package course.c05;

public class ExampleRunnable implements Runnable {
	private int i; // 將被共用!!

	@Override
	public void run() {
		for (i = 0; i < 10; i++) {
			System.out.print("i:" + i + ", ");
		}
	}

	public static void main(String[] args) {
		ExampleRunnable r1 = new ExampleRunnable();
		Thread t1 = new Thread(r1);
		t1.start();
		Thread t2 = new Thread(r1);
		t2.start();
	}
}
