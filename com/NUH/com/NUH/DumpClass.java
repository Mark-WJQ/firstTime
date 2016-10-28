package com.NUH;

import java.lang.reflect.Method;

public class DumpClass {

	
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> classType = Class.forName("java.lang.String");
		Method[] methods = classType.getDeclaredMethods();
		for(Method m : methods){
			System.out.println(m);
		}
	}
}
