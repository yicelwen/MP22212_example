package course.c04;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SeekableByteChannelTest {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("dir/c04/file.txt").toAbsolutePath();

		try (SeekableByteChannel sbc = Files.newByteChannel(path, StandardOpenOption.WRITE)) {

			long channelSize = sbc.size();
			sbc.position(channelSize);
			System.out.println("position: " + sbc.position());

			ByteBuffer buffer = ByteBuffer.wrap(("\n" + "0").getBytes());

			sbc.write(buffer);
			System.out.println("position: " + sbc.position());
		}

	}

}
