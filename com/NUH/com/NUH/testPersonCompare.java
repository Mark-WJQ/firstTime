package com.NUH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class testPersonCompare implements Comparable<testPersonCompare>, Comparator<testPersonCompare> {

	
	private String name;
	private int age;
	
	public testPersonCompare(){
		
	}
	
	public testPersonCompare(String name,int age){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compare(testPersonCompare p1, testPersonCompare p2) {
		// TODO Auto-generated method stub
		return p1.age - p2.age;
	}

	@Override
	public int compareTo(testPersonCompare p) {
		// TODO Auto-generated method stub
		return p.age - age;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<testPersonCompare> pList = new ArrayList<testPersonCompare>();
		pList.add(new testPersonCompare("aaa", 3));
		pList.add(new testPersonCompare("bbb", 5));
		pList.add(new testPersonCompare("ddd", 10));
		pList.add(new testPersonCompare("vvv", 7));
		pList.add(new testPersonCompare("nnn", 8));
		pList.add(new testPersonCompare("mmm", 9));
		
		System.out.println("未排序前：");
		for(testPersonCompare p : pList){
			System.out.print(p.getName());
		}
		
		//Collections.sort(pList);
		Collections.sort(pList, new testPersonCompare());
		System.out.println("排序后：");
		for(testPersonCompare p : pList){
			System.out.print(p.getName());
		}
		

	}
	
}
