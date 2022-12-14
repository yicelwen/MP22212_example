package course.c06;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		int stopUntil = 2;
		int totalThreadCnt = 3;
		final CyclicBarrier barrier = new CyclicBarrier(stopUntil);
		for (int i=1; i<=totalThreadCnt; i++) {
			new Thread() {
				public void run() {
					try {
						System.out.println("before await");
						barrier.await();
						System.out.println("after await");
					} catch (BrokenBarrierException | InterruptedException ex) {
					}
				}
			}.start();
		}
	}
}
