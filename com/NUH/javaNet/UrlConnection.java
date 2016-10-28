package javaNet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.MappedByteBuffer;

public class UrlConnection {
	
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.infoq.com");
		URLConnection connection = url.openConnection();
		InputStream is = connection.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		byte[] buffer = new byte[2048];
		
		File file = new File("D:/infoq.html");
		OutputStream os = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(os);
		int length = 0;
		while(-1 != (length = bis.read(buffer))){
			bos.write(buffer);
			//os.write(buffer,0,length);
		}
		bos.flush();
		bos.close();
		os.close();
		bis.close();
		is.close();
	}
	

}
