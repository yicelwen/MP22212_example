package course.c04;

import java.nio.file.*;
import java.io.IOException;

public class DiskUsage {
	static void printFileStore(FileStore store) throws IOException {
		long toGB = 1024 * 1024 * 1024;
		long total = store.getTotalSpace() / toGB;
		long used = store.getTotalSpace() / toGB - store.getUnallocatedSpace() / toGB;
		long avail = store.getUsableSpace() / toGB;
		System.out.format("%-20s %12d(GB) %12d(GB) %12d(GB)\n", store.toString(), total, used, avail);
	}

	public static void main(String[] args) throws IOException {
		System.out.format("%-20s %12s %12s %12s\n", "Filesystem", "total", "used", "avail");
		if (args.length == 0) {
			for (FileStore store : FileSystems.getDefault().getFileStores()) {
				printFileStore(store);
			}
		} else {
			for (String file : args) {
				FileStore store = Files.getFileStore(Paths.get(file));
				printFileStore(store);
			}
		}
	}
}