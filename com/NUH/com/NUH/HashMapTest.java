package com.NUH;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {
	
	public static final HashMap<String, String> firstHashMap = new HashMap<String,String>();
	
	public static void main(String[] args) throws InterruptedException {
		//线程1
		Thread t1 = new Thread(){
			public void run(){
				for(int i = 0;i < 25; i ++){
					firstHashMap.put(String.valueOf(i), String.valueOf(i));
				}
			}
		};
		//线程2
		
		Thread t2 = new Thread(){
			public void run(){
				for(int i = 25;i < 50; i++){
					firstHashMap.put(String.valueOf(i), String.valueOf(i));
				}
			}
		};
		
		t1.start();
		t2.start();
		
		Thread.currentThread().sleep(1000);
		
		for(int i = 0;i < 50; i++){
			System.out.println(firstHashMap.get(String.valueOf(i)));
			/*if(!String.valueOf(i).equals(firstHashMap.get(String.valueOf(i)))){
				System.err.println(String.valueOf(i)+":"+firstHashMap.get(String.valueOf(i)));
			}*/
		}
	}

}
