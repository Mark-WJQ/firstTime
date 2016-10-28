package com.NUH;

public class SingleTonTest {
	public static void main(String[] args){
		SingleTon s1 = SingleTon.getInstance();
		SingleTon s2 = SingleTon.getInstance();
		System.out.println(s1 == s2);
	}
}


class SingleTon{
	
	private static SingleTon st;
	
	private SingleTon(){
		
	}
	
	public static SingleTon getInstance(){
		if(st == null)
			st = new SingleTon();
		return st;
	}
}