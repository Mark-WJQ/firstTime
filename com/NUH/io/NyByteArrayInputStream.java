package io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class NyByteArrayInputStream extends InputStream{

	
	protected byte[] data;
	protected int prt = 0;
	
	public NyByteArrayInputStream(byte[] data){
		this.data = data;
	}
	
	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
	
		return (prt < data.length) ? (data[prt++]):-1;
	}
	
	
	public static void main(String[] args) throws IOException {
		byte[] b = new byte[16];
		for(int i = 0; i < b.length ;i++){
			b[i] = (byte) i;
		}
		
		NyByteArrayInputStream mb = new NyByteArrayInputStream(b);
		while(true){
			int c = mb.read();
			if(c < 0)
				break;
			System.out.print(c + " ");
		}
		
	}

	
	
	

}
