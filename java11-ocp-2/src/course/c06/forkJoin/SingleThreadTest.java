package course.c06.forkJoin;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class SingleThreadTest {
    public static void main(String[] args) {
    	Date begin = new Date();
    	//製作資料
        int[] bigData = new int[1024 * 1024 * 256]; // 1G
        for (int i = 0; i < bigData.length; i++) {
            bigData [i] = ThreadLocalRandom.current().nextInt();
        }
        int max = Integer.MIN_VALUE;
        for (int value : bigData) {
            if (value > max) {
                max = value;
            }
        }
        System.out.println("Found max value:" + max);
        long t = new Date().getTime() - begin.getTime();
        System.out.println("Complete task within " + t + " milliseconds");
    }
}
