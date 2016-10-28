package com.NUH;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class GetChannel {
	private static final int BSIZE  = 1024;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		bufferToText();
		//testCharBuffer();
	}

	private static void testCharBuffer() {
		// TODO Auto-generated method stub
		CharBuffer cb = CharBuffer.allocate(BSIZE);
		System.out.println("position=="+cb.position()+"limit===="+cb.limit()+"capacity===="+cb.capacity());
		cb.put("testCharBuffer");
		cb.flip();
		while(cb.hasRemaining()){
			System.out.print(cb.get());
		}
		
	}

	public static void bufferToText() {
		try {
			FileChannel fc = new FileOutputStream("C:\\Users\\NUH-25\\Desktop\\test.txt").getChannel();
			fc.write(ByteBuffer.wrap("some test".getBytes()));
			fc.close();
			fc = new FileInputStream("C:\\Users\\NUH-25\\Desktop\\test.txt").getChannel();
			ByteBuffer buffer = ByteBuffer.allocateDirect(BSIZE);
			fc.read(buffer);
			buffer.flip();
			while(buffer.hasRemaining()){
				System.out.print((char)buffer.get());
			}
			
			
			
			
			buffer.rewind();
			String encoding = System.getProperty("file.encoding");
			System.out.println("Decoded using "+encoding+":"+Charset.forName(encoding).decode(buffer));
			
			
			fc = new FileOutputStream("C:\\Users\\NUH-25\\Desktop\\test.txt").getChannel();
			fc.write(ByteBuffer.wrap("some text".getBytes("UTF-16BE")));
			fc.close();
			fc = new FileInputStream("C:\\Users\\NUH-25\\Desktop\\test.txt").getChannel();
			buffer.clear();
			fc.read(buffer);
			buffer.flip();
			while (buffer.hasRemaining()) {
				System.out.print(buffer.getChar());
			}
			
			
			fc = new FileOutputStream("C:\\Users\\NUH-25\\Desktop\\test.txt").getChannel();
			buffer = ByteBuffer.allocate(24);
			buffer.asCharBuffer().put("some tsxt");
			fc.write(buffer);
			fc.close();
			
			
			fc = new FileInputStream("C:\\Users\\NUH-25\\Desktop\\test.txt").getChannel();
			buffer.clear();
			fc.read(buffer);
			buffer.flip();
			System.out.println(buffer.asCharBuffer());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
