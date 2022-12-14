package course.c04;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import static java.nio.file.StandardWatchEventKinds.*;

class MyWatchService implements Runnable {

	private WatchService myWatcher;

	public MyWatchService(WatchService myWatcher) {
		this.myWatcher = myWatcher;
	}

	@Override
	public void run() {
		try {
			WatchKey key = myWatcher.take();
			while (key != null) {
				for (WatchEvent event : key.pollEvents()) {
					System.out.printf("Received event: %s for file: %s\n", event.kind(), event.context());
				}
				key.reset();
				key = myWatcher.take();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class WatchServiceTest {

	final static String DIRECTORY_TO_WATCH = "D://WatchServiceTest";

	public static void main(String[] args) throws Exception {

		Path watchPath = Paths.get(DIRECTORY_TO_WATCH);
		if (Files.exists(watchPath) == false) {
			Files.createDirectories(watchPath);
		}

		WatchService myWatcher = watchPath.getFileSystem().newWatchService();

		MyWatchService fileWatcher = new MyWatchService(myWatcher);
		Thread thread = new Thread(fileWatcher);
		thread.start();

		// register a file
		watchPath.register(myWatcher, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
		thread.join();
	}
}
