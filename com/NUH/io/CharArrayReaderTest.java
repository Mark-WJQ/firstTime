package io;

import java.io.CharArrayReader;
import java.io.IOException;
import java.util.Properties;

import groovy.ui.SystemOutputInterceptor;

public class CharArrayReaderTest {
	
	
	public static void main(String[] args) throws IOException {
		
		String tmp = "abcdeff";
		char[] ch = new char[tmp.length()];
		
		tmp.getChars(0, tmp.length(), ch, 0);
		CharArrayReader car = new CharArrayReader(ch);
		int i;
		while(-1 != (i = car.read())){
			System.out.println((char)i);
		}
		Properties p = System.getProperties();
		p.list(System.out);
		
	}
	

}
