package com.NUH;

public class ClassTest {
	
	public static void main(String[] args) {
		Class<?> classType = Child.class;
		System.out.println(classType);
		Class<?> superClass = classType.getSuperclass();
		System.out.println(superClass);
	}
}


class Parent1{
	
}

class Child extends Parent1{
	
}