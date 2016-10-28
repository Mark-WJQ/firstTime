package com.NUH;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateTest {
	
	
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		PerivateBeTest p = new PerivateBeTest();
		Class<?> classType = p.getClass();
		Method method = classType.getDeclaredMethod("sayHello",String.class);
		method.setAccessible(true);
		String str = (String) method.invoke(p, "Mark");
		System.out.println(str);
		
		Field field = classType.getDeclaredField("name");
		field.setAccessible(true);
		field.set(p, "lisi");
		System.out.println(p.getName());
		
	}
	
	
}
