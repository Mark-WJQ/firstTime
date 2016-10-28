package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestFile {

	
	public static void main(String[] args) throws IOException {
		File file = new File("C:/test");
		System.out.println(file.mkdirs());
		
		
		InputStream is = new FileInputStream("");
		byte[] b = new byte[1024];
		if(is.read(b) > 0){
			
		}
		
	}
	
}
