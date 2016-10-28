package com.NUH;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class GetData {
	private static final int BSIZE = 1024;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//getDataTest();
		endians();
	}

	private static void endians() {
		// TODO Auto-generated method stub
		ByteBuffer buffer = ByteBuffer.wrap(new byte[12]);
		buffer.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(buffer.array()));
		buffer.rewind();
		buffer.order(ByteOrder.BIG_ENDIAN);
		buffer.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(buffer.array()));
		buffer.rewind();
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		buffer.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(buffer.array()));
		System.out.println("position=="+buffer.position()+"limit===="+buffer.limit()+"capacity===="+buffer.capacity());
		//buffer.flip();
		//System.out.println("position=="+buffer.position()+"limit===="+buffer.limit()+"capacity===="+buffer.capacity());
		while(buffer.hasRemaining()){
			System.out.print(buffer.getShort());
		}
	}

	public static void getDataTest() {
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		int i = 0;
		while(i++ < buffer.limit()){
			if(buffer.get() != 0){
				System.out.print("nozero");
			}
		}
		System.out.println("i="+i);
		buffer.rewind();
		System.out.println("position=="+buffer.position()+"limit===="+buffer.limit()+"capacity===="+buffer.capacity());
		buffer.asCharBuffer().put("Howdy!");
		char c;
		while((c = buffer.getChar())!=0){
			System.out.print(c + " ");
		}
		System.out.println("");
		buffer.rewind();
		buffer.asShortBuffer().put((short)471142);
		System.out.println(buffer.getShort());
		buffer.rewind();
		
		
		buffer.asIntBuffer().put(99471142);
		System.out.println(buffer.getInt());
		buffer.rewind();
		
		
		buffer.asLongBuffer().put(99471142);
		System.out.println(buffer.getLong());
		buffer.rewind();
		
		buffer.asFloatBuffer().put(99471142);
		System.out.println(buffer.getFloat());
		buffer.rewind();
		
		
		buffer.asDoubleBuffer().put(99471142);
		System.out.println(buffer.getDouble());
		buffer.rewind();
	}

}
