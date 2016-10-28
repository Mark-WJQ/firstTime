package com.NUH;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockingMappingFiles {

	static final int LENGTH  = 0x8FFFFFF;
	static FileChannel fc;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			fc = new RandomAccessFile("C:\\Users\\NUH-25\\Desktop\\test.txt", "rw").getChannel();
			MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
			for(int i = 0; i < LENGTH ; i++){
				out.put((byte)'x');
			}
			//new LockAndModify(out, 0, 0+LENGTH/3);
			//new LockAndModify(out, LENGTH/2, LENGTH/2+LENGTH/4);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	private static class LockAndModify extends Thread {
		private ByteBuffer buff;
		private int start ,end;
		public LockAndModify(ByteBuffer mbb,int start, int end) {
			super();
			this.start = start;
			this.end = end;
			mbb.limit(end);
			mbb.position(start);
			buff = mbb.slice();
			start();
		}
		
		public void run(){
			try {
				FileLock fl = fc.tryLock(start,end,false);
				System.out.println("Locked: "+start + " to " + end);
				while(buff.position() < buff.limit()-1){
					buff.put((byte) (buff.get()-1));
				}
				fl.release();
				System.out.println("Release: "+start + " to " + end);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
