package com.NUH;

import java.lang.reflect.Array;

public class ArrayTest1 {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class calssType = Class.forName("java.lang.String");
		Object array = Array.newInstance(calssType, 10);
		Array.set(array, 5, "hello");
		
		int[] dims = new int[] {5,10,15};
		Object array1 = Array.newInstance(Integer.TYPE, dims);
		Object arrObject = Array.get(array1, 3);
		Class classType1 = arrObject.getClass().getComponentType();
		
		arrObject = Array.get(arrObject, 5);
		Array.setInt(arrObject, 10, 37);
		int [] [] [] arrayCast = (int[][][]) array1;
		System.out.println(arrayCast[3][5][10]);
		System.out.println(classType1);
				
		
	}
	
	
	

}
