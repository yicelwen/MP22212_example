package course.c04;


import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.regex.PatternSyntaxException;

public class FilesMoveTest {

	
	public static void main(String[] args) throws IOException {
		
		init("moveTo");

		testMove();

		
	}

	@SuppressWarnings("unused")
	private static void testMove() throws IOException {
		
		Path pFromBasic = Paths.get("dir/c04/from");
		Path pTo = Paths.get("dir/c04/moveTo/");
	
		String target = null;
		
		// 1. Move file to file (different name)
		target = "fileFrom.txt";
		Files.move(pFromBasic.resolve(target), pTo.resolve(target + ".mv"));
		clean(pTo);
		
		
		// 2. Move file to existed file (the same name)
		target = "fileFrom1.txt";
		Files.copy(pFromBasic.resolve(target), pTo.resolve(target));
		try {
			Files.move(pFromBasic.resolve(target), pTo.resolve(target));	// no REPLACE_EXISTING
		} catch (java.nio.file.FileAlreadyExistsException e) {
			e.printStackTrace();
		}
		try {
			Files.move(pFromBasic.resolve(target), pTo.resolve(target), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		clean(pTo);
		
		
		// 3. Move file to directory
		target = "fileFrom2.txt";
		Path movedFile = Files.move(pFromBasic.resolve(target), Paths.get("dir/c04/moveTo1/"));
		Files.delete(movedFile);
		
		
		// 4. Move file to existed & empty directory
		target = "fileFrom3.txt";
		try {
			Path mv = Files.move(pFromBasic.resolve(target), Paths.get("dir/c04/moveTo2/"));	// no REPLACE_EXISTING
			//java.nio.file.FileAlreadyExistsException: dir\c04\moveTo2
			Files.delete(mv);
		} catch (java.nio.file.FileAlreadyExistsException e) {
			e.printStackTrace();
		}
		try {
			Path mv = Files.move(pFromBasic.resolve(target), Paths.get("dir/c04/moveTo2/"), StandardCopyOption.REPLACE_EXISTING);
			Files.delete(mv);
			Files.createDirectories(Paths.get("dir/c04/moveTo2/"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// 5. Move file to existed & non-empty directory
		target = "fileFrom4.txt";
		try {
			Path mv = Files.move(pFromBasic.resolve(target), Paths.get("dir/c04/moveTo3/"), StandardCopyOption.REPLACE_EXISTING);
			//java.nio.file.DirectoryNotEmptyException: dir\c04\moveTo3
			Files.delete(mv);
		} catch (java.nio.file.DirectoryNotEmptyException e) {
			e.printStackTrace();
		}
		
		/*******************************************************************************/
		
		
		// try symbolicLink copy
		target = "fileLink.sl";
		
//		Files.move(pFromBasic.resolve(target), pTo.resolve(target));	// default will copy the linked file
//		clean(pTo);
		
//		Files.move(pFromBasic.resolve(target), pTo.resolve(target), LinkOption.NOFOLLOW_LINKS);
//		clean(pTo);

		Files.move(pFromBasic.resolve(target), pTo.resolve(target), StandardCopyOption.REPLACE_EXISTING);
		clean(pTo);
		
		/*******************************************************************************/
		
		// dir move to dir
		target = "dirFrom";
		Path p = Files.move(pFromBasic.resolve(target), pTo.resolve(target + ".mv"));
		Files.delete(p);
		
		
		
		// move directory to existed directory
		target = "dirFrom1";
		Files.copy(pFromBasic.resolve(target), pTo.resolve(target));
		try {
			Files.move(pFromBasic.resolve(target), pTo.resolve(target));	// no REPLACE_EXISTING
		} catch (java.nio.file.FileAlreadyExistsException e) {
			e.printStackTrace();
		}
		try {
			Path p1 = Files.move(pFromBasic.resolve(target), pTo.resolve(target), StandardCopyOption.REPLACE_EXISTING);
			//Files.delete(p1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// move directory to directory
		target = "dirFrom2";
		Path p3 = Files.move(pFromBasic.resolve(target), Paths.get("dir/c04/moveTo1"));
		Files.delete(p3);
		
		
		// move directory to existed & empty directory
		target = "dirFrom3";
		try {
			Path p4 = Files.move(pFromBasic.resolve(target), Paths.get("dir/c04/moveTo2"));	// no REPLACE_EXISTING
			Files.delete(p4);
		} catch (java.nio.file.FileAlreadyExistsException e) {
			e.printStackTrace();
		}
		Path p5 = Files.move(pFromBasic.resolve(target), Paths.get("dir/c04/moveTo2"), StandardCopyOption.REPLACE_EXISTING);
		Files.delete(p5);
		Files.createDirectories(Paths.get("dir/c04/moveTo2/"));
		
		
		// move directory to existed & non-empty directory
		target = "dirFrom4";
		try {
			Path mv = Files.move(pFromBasic.resolve(target), Paths.get("dir/c04/moveTo3"), StandardCopyOption.REPLACE_EXISTING);
			Files.delete(mv);
		} catch (java.nio.file.DirectoryNotEmptyException e) {
			e.printStackTrace();
		}
		
		// non-empty dir move to non-existed & empty directory
		target = "dirFromWithFile";
		try {
			Path mv = Files.move(pFromBasic.resolve(target), pTo.resolve(target));
			//Files.delete(mv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
	}

	private static void clean(Path dir) {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*")) {
			for (Path file : stream) {
				//System.out.println("Try to delete " + file.getFileName());
				Files.deleteIfExists(file);
			}
		} catch (PatternSyntaxException | DirectoryIteratorException | IOException x) {
			System.err.println(x);
		}
	}
	
	private static void init(String type) throws IOException {
		
		Path pFrom = Paths.get("dir/c04/from").toAbsolutePath();
		Files.walkFileTree(pFrom, new FileRemoveVisitor());
		Files.createDirectories(pFrom);
		
		Path pTo = Paths.get("dir/c04/" + type + "/").toAbsolutePath();
		Files.walkFileTree(pTo, new FileRemoveVisitor());
		Files.createDirectories(pTo);
		
		Path pFromOri = Paths.get("dir/c04/from_ori").toAbsolutePath();
		Files.walkFileTree(pFromOri, new FileCopyVisitor(pFrom));

	}

}
