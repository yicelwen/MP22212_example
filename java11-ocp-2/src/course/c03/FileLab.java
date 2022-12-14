package course.c03;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import static java.lang.System.out;

public class FileLab {

	public static void main(String[] args) {

		String dirname = System.getProperty("user.dir") + "/src/course/c03/";
		File root = new File(dirname);
		if (root.isDirectory()) {
			File[] fs = root.listFiles();
			for (File f : fs) {
				if (f.isDirectory()) {
					out.println(f.getAbsolutePath() + " is a directory");
				} else {
					out.println(f.getName() + " is a file");
				}
			}
		}
		out.println();
		try {
			File temp = File.createTempFile("jim", null, root);
			String n = temp.getName();
			out.println(n + " is created? " + temp.exists());
			out.println(n + " is created at " + new Date(temp.lastModified()));
			out.println(n + " can read? " + temp.canRead());
			out.println(n + " can write? " + temp.canWrite());
			out.println(n + " set read only? " + temp.setReadOnly());
			out.println(n + " is deleted? " + temp.delete());
			out.println(n + " is existed? " + temp.exists());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
