package replaybot.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class FileUtils {

	public static boolean saveFile(InputStream fileInputStream, String outputFile) {
		try(FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
			ReadableByteChannel fileInputChannel = Channels.newChannel(fileInputStream);
			FileChannel fileOutputChannel = fileOutputStream.getChannel();
			
			fileOutputChannel.transferFrom(fileInputChannel, 0, Long.MAX_VALUE);
		} catch (IOException e) {
			e.printStackTrace();
			
			return false;
		}
		
		return true;
	}
	
	
}
