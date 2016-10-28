package com.NUH;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] data = "UsingBuffers".toCharArray();
		ByteBuffer buffer = ByteBuffer.allocate(data.length*2);
		CharBuffer cb = buffer.asCharBuffer();
		cb.put(data);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
		
	}

	private static void symmetricScramble(CharBuffer cb) {
		// TODO Auto-generated method stub
		while(cb.hasRemaining()){
			cb.mark();  
			//System.out.println(cb.mark());
			char c1 = cb.get();
			char c2 = cb.get();
			cb.reset();     //pos == mark
			cb.put(c2).put(c1);
		}
	}

}
