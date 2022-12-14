package course.c06;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class TableData {
	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	static void sleep(int secs) {
		try {
			Thread.sleep(1000 * secs);
		} catch (Exception e) {}
	}
	public void update() {
		rwl.writeLock().lock();
		System.out.println("holding write lock");
		sleep(3);
		rwl.writeLock().unlock();
		System.out.println("released write lock");
	}
	public void delete() {
		rwl.writeLock().lock();
		System.out.println("holding write lock");
		sleep(3);
		rwl.writeLock().unlock();
		System.out.println("released write lock");
	}
	public void query() {
		rwl.readLock().lock();
		System.out.println("holding read lock");
		sleep(3);
		rwl.readLock().unlock();
		System.out.println("released read lock");
	}
}

public class ReadWriteLockTest {
	static void query(final TableData lock) {
		new Thread() {
			public void run() {
				lock.query();
			}
		}.start();
	}
	static void delete(final TableData lock) {
		new Thread() {
			public void run() {
				lock.delete();
			}
		}.start();
	}
	static void update(final TableData lock) {
		new Thread() {
			public void run() {
				lock.update();
			}
		}.start();
	}
	static void counting() {
		new Thread() {
			public void run() {
				int i = 0;
				while (true) {
					TableData.sleep(1);
					System.out.println(i++);
				}
			}
		}.start();
	}

	public static void main(String[] args) {
		counting();
		final TableData table = new TableData();
		query(table);
		query(table);
		update(table);
		delete(table);
		query(table);
		query(table);
		update(table);
	}
}
