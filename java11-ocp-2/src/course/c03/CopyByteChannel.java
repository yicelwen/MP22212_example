package course.c03;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyByteChannel {
	public static void main(String[] args) {
		String source = "", target = "";
		try (FileChannel in = new FileInputStream(source).getChannel();
				FileChannel out = new FileOutputStream(target).getChannel()) {
			ByteBuffer buff = ByteBuffer.allocate((int) in.size());
			in.read(buff);
			buff.position(0);
			out.write(buff);
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}
