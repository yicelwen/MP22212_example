package course.c05;

import java.util.Date;

class SynchronizedAll {
	private void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
	}
	public synchronized void m1() {
		sleep();
		System.out.println("-- Run m1() at: " + new Date());
	}
	public synchronized void m2() {
		sleep();	
		System.out.println("-- Run m2() at: " + new Date());
	}
}


class M1Runner extends Thread {
	SynchronizedAll o;
	M1Runner(SynchronizedAll o) {
		this.o = o;
	}
	public void run() {
		o.m1();
	}
}

class M2Runner extends Thread {
	SynchronizedAll o;
	M2Runner(SynchronizedAll o) {
		this.o = o;
	}
	public void run() {
		o.m2();
	}
}

public class SynchronizedTest {
	public static void main(String[] args) {
		SynchronizedAll o = new SynchronizedAll();
		System.out.println("Start main at: " + new Date());
		Thread m1 = new M1Runner(o);
		m1.start();
		Thread m2 = new M2Runner(o);
		m2.start();
		//m1.interrupt();
		System.out.println("End main at: " + new Date());
	}
}
