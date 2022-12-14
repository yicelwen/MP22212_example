package course.c04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import static java.lang.System.out;

public class MetadataTest {
	public static void main(String[] args) throws IOException {
		Path basic = Paths.get("dir/c04/metadata").toAbsolutePath();
		out.println("basic path: " + basic);
		
		Path common = basic.resolve("file.txt");
		Path shortcut = basic.resolve("dir.shortcut");
		Path hidden = basic.resolve("hiddenFile");
		Path symlink = basic.resolve("dir.sl");
		
		out.println("size: " + Files.size(common));
		out.println("isDirectory: " + Files.isDirectory(common));
		out.println("isRegularFile: " + Files.isRegularFile(common));		
		out.println("isSymbolicLink(dir.sl): " + Files.isSymbolicLink(symlink));
		out.println("isSymbolicLink(dir.shortcut): " + Files.isSymbolicLink(shortcut));
		out.println("isHidden: " + Files.isHidden(hidden));	
		
		//取得並修改LastModifiedTime
		out.println("getLastModifiedTime: " + Files.getLastModifiedTime(common));
		FileTime t = FileTime.fromMillis(new Date().getTime());
		Files.setLastModifiedTime(common, t);
		out.println("getLastModifiedTime: " + Files.getLastModifiedTime(common));
		//設定hidden屬性
		Files.setAttribute (hidden, "dos:hidden", Boolean.valueOf(false));
		out.println("isHidden: " + Files.getAttribute(hidden, "dos:hidden"));
	}
}
