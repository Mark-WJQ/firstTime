package com.NUH;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class javaNio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//bufferMethod();
		//channelwrite();
		//channelRead();
		channelMap();
	}

	private static void channelMap() {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\NUH-25\\Desktop\\URL.txt");
		try {
			FileInputStream inputStream = new FileInputStream(file);
			FileChannel channel = inputStream.getChannel();
			MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());  //将文件映射到内存中
			byte[] data = new byte[(int) file.length()];
			int index = 0;
			while(mappedByteBuffer.hasRemaining()){
				data[index++] = mappedByteBuffer.get();
			}
			System.out.println(new String(data));
			channel.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void channelRead() {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\NUH-25\\Desktop\\URL.txt");
		File outfile = new File("C:\\Users\\NUH-25\\Desktop\\test.txt");
		FileInputStream input = null;
		FileOutputStream output = null;
		try {
			input = new FileInputStream(file);
			output = new FileOutputStream(outfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileChannel fileChannel = null;
		FileChannel outChannel = null;
		fileChannel = input.getChannel();
		outChannel = output.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		int tmp = 0;
		try {
			while((tmp = fileChannel.read(buffer))!= -1){
				buffer.flip();
				outChannel.write(buffer);
				buffer.clear();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			input.close();
			output.close();
			fileChannel.close();
			outChannel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void channelwrite() {
		String[] data = {"scals","spark","java","haddop"};
		File file = new File("C:\\Users\\NUH-25\\Desktop\\test.txt");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			FileChannel channel = fileOutputStream.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			for(String item : data){
				buffer.put(item.getBytes());
			}
			buffer.flip();
			channel.write(buffer);
			channel.close();
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void bufferMethod() {
		IntBuffer buffer = IntBuffer.allocate(100);  //开辟容量为100大小的IntBuffer
		System.out.println("position=="+buffer.position()+"limit===="+buffer.limit()+"capacity===="+buffer.capacity());
		int[] data = {9,8,7,6,5,4,3,2,1,0};  //定义证书数组
		buffer.put(100);   //向缓存区写入一个整数
		buffer.put(data);   //将数组放入缓存
		System.out.println("position=="+buffer.position()+"limit===="+buffer.limit()+"capacity===="+buffer.capacity());
		buffer.flip();    //重设缓存区
		System.out.println("position=="+buffer.position()+"limit===="+buffer.limit()+"capacity===="+buffer.capacity());
		while(buffer.hasRemaining()){
			System.out.println(buffer.get());
		}
		
		buffer.position(2);
		buffer.limit(4);
		IntBuffer subBuffer = buffer.slice();
		for(int i = 0;i<subBuffer.capacity();i++){
			int k = subBuffer.get(i);
			subBuffer.put(i, k-100);
		}
		buffer.flip();
		while(buffer.hasRemaining()){
			System.out.println(buffer.get());
		}
		System.out.println("===================");
		while(subBuffer.hasRemaining()){
			System.out.println(subBuffer.get());
		}
	}

}
