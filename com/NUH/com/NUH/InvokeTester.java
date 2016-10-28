package com.NUH;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class InvokeTester {
	
	public int add(int p1 , int p2){
		return p1 + p2;
	}
	
	public String echo(String p){
		return "hello: " + p;
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class<InvokeTester> classType = InvokeTester.class;
		InvokeTester invokeTester = classType.newInstance();
		//System.out.println(invokeTester instanceof InvokeTester);
		
		Method m1 = classType.getMethod("add", new Class[]{int.class,int.class});
		System.out.println(m1.invoke(invokeTester, 1,2));
		
		
		Method m2 = classType.getMethod("echo",String.class);
		System.out.println(m2.invoke(invokeTester, "hdjhdj"));
	}

}
