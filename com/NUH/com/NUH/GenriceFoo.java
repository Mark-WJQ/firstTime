package com.NUH;

import java.util.ArrayList;

public class GenriceFoo <T>{
	
	T foo;
	
	
	public T getFoo() {
		return foo;
	}


	public void setFoo(T foo) {
		this.foo = foo;
	}


	ArrayList<T> a = new ArrayList<>();
	
	
	public static void main(String[] args) {
		GenriceFoo<String> gf = new GenriceFoo<String>();
		gf.setFoo("ssss");
	}
	
}
