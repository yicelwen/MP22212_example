package course.c06.forkJoin;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

class FindMaxTask extends RecursiveTask<Integer> {
	static int counter = 0;
	private static final long serialVersionUID = 1L;
	private final int threshold;
	private final int[] data;
	private int begin;
	private int end;

	public FindMaxTask(int[] data, int begin, int end, int threshold) {
		this.data = data;
		this.begin = begin;
		this.end = end;
		this.threshold = threshold;
	}

	@Override
	protected Integer compute() {
		if (end - begin < threshold) {
			System.out.printf("%02d", ++counter);
			System.out.print(": " + Thread.currentThread().getName());
			System.out.println(" |Range: " + begin + " ~ " + end);
			int max = Integer.MIN_VALUE;
			for (int i = begin; i <= end; i++) {
				int n = data[i];
				if (n > max) {
					max = n;
				}
			}
			return max;
		} else {
			int mid = (end - begin) / 2 + begin;
			FindMaxTask a1 = new FindMaxTask(data, begin, mid, threshold);
			a1.fork();
			FindMaxTask a2 = new FindMaxTask(data, mid + 1, end, threshold);
			return Math.max(a2.compute(), a1.join());
		}
	}
}

public class ForkJoinMultiThreadTest {
	public static void main(String[] args) {
		Date begin = new Date();
		// 製作資料
		int[] bigData = new int[1024 * 1024 * 256]; // 1G
		for (int i = 0; i < bigData.length; i++) {
			bigData[i] = ThreadLocalRandom.current().nextInt();
		}
		// 使用fork-join框架
		FindMaxTask task = new FindMaxTask(bigData, 0, bigData.length - 1, bigData.length / 16);
		ForkJoinPool pool = new ForkJoinPool();
		Integer max = pool.invoke(task);
		System.out.println("\nMax value found:" + max);
		// 計時
		long t = new Date().getTime() - begin.getTime();
		System.out.println("Complete task within " + t + " milliseconds");
	}
}
