package com.NUH;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReFlectClass {
	//该方法实现对Customer对象的拷贝操作
	public static Object copy(Object object) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<?> classType = object.getClass();
		Constructor<?> con = classType.getConstructor();
		Object obj = con.newInstance();
		Field[] fields = classType.getDeclaredFields();
		for(Field field:fields){
			String name = field.getName();
			String fisterLetter = name.substring(0, 1).toUpperCase();
			String getMethodName = "get" + fisterLetter + name.substring(1);
			String setMethodName = "set" + fisterLetter + name.substring(1);
			Method getMethod = classType.getMethod(getMethodName);
			Method setMethod = classType.getMethod(setMethodName, field.getType());
			
			Object value = getMethod.invoke(object);
			setMethod.invoke(obj, value);
			
		}
		return obj;
	}
	
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Customer customer = new Customer();
		customer.setId(1l);
		customer.setAge(10);
		customer.setName("world");
		Customer newCustomer = (Customer)copy(customer);
		System.out.println(newCustomer.getAge() +"===="+ newCustomer.getId() +"=====" + newCustomer.getName());
	}
}


class Customer{
	private int age;
	private String name;
	private long id;
	
	public Customer(){
		
	}
	
	public Customer(String name , int age){
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
	
}