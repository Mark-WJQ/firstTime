package com.NUH;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class MappedIo {
	
	private static int numOfInts = 4000000;
	private static int numOfUbuffInts = 200000;
	
	private abstract static class Tester{
		private String name;
		
		public Tester(String name){
			this.name = name;
		}
		
		public void runTest(){
			System.out.print(name+": ");
			long start = System.nanoTime();
			try {
				test();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double duration = System.nanoTime() - start;
			System.out.format("%.2f\n", duration/1.0e9);
		}

		public abstract void test() throws IOException;
	}
	
	
	private static Tester[] tests = {
		new Tester("Stream Write") {
			
			@Override
			public void test() throws IOException {
				// TODO Auto-generated method stub
				DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\NUH-25\\Desktop\\test.txt"))));
				for(int i =0;i < numOfInts;i++){
					dos.writeInt(i);
				}
				dos.close();
			}
		},
		
		new Tester("Mapped Write") {
			
			@Override
			public void test() throws IOException {
				// TODO Auto-generated method stub
				FileChannel fc = new RandomAccessFile("C:\\Users\\NUH-25\\Desktop\\test.txt","rw").getChannel();
				IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
				for(int i = 0; i < numOfInts;i++){
					ib.put(i);
				}
				fc.close();
				
			}
		},
		
		new Tester("Stream read") {
			
			@Override
			public void test() throws IOException {
				// TODO Auto-generated method stub
				DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("C:\\Users\\NUH-25\\Desktop\\test.txt"))));
				for(int i = 0; i < numOfInts; i++){
					dis.readInt();
				}
				dis.close();
			}
		},
		new Tester("Mapped Read") {
			
			@Override
			public void test() throws IOException {
				// TODO Auto-generated method stub
				FileChannel fc = new FileInputStream(new File("C:\\Users\\NUH-25\\Desktop\\test.txt")).getChannel();
				IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
				while(ib.hasRemaining()){
					ib.get();
				}
				fc.close();
			}
		},
		
		new Tester("Stream Write/read") {
			
			@Override
			public void test() throws IOException {
				// TODO Auto-generated method stub
				RandomAccessFile raf = new RandomAccessFile(new File("C:\\Users\\NUH-25\\Desktop\\test.txt"), "rw");
				raf.writeInt(1);
				for(int i = 0;i < numOfUbuffInts; i++){
					raf.seek(raf.length()-4);
					raf.writeInt(raf.readInt());
				}
				raf.close();
			}
		},
		new Tester("Mapped Write/read") {
			
			@Override
			public void test() throws IOException {
				// TODO Auto-generated method stub
				FileChannel fc = new RandomAccessFile(new File("C:\\Users\\NUH-25\\Desktop\\test.txt"), "rw").getChannel();
				IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
				ib.put(0);
				for(int i = 1;i < numOfUbuffInts;i++){
					ib.put(ib.get(i-1));
				}
				fc.close();
			}
		}
	};
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(Tester tester:tests){
			tester.runTest();
		}

	}
	
	
	

}
