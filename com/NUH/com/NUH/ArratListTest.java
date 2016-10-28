package com.NUH;

import java.util.ArrayList;
import java.util.Comparator;

public class ArratListTest implements Comparator<ArratListTest> {
	
	int x;
	int y;
	
	public ArratListTest(){
		
	}
	
	public ArratListTest(int x,int y){
		this.x = x;
		this.y = y;
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		ArrayList<ArratListTest> list = new ArrayList<>();
		list.add(new ArratListTest(1, 3));
		list.add(new ArratListTest(5, 3));
		list.add(new ArratListTest(21, 3));
		list.add(new ArratListTest(12, 3));
		list.add(new ArratListTest(6, 3));
		list.add(new ArratListTest(8, 3));
		list.sort(new ArratListTest());
		for(int i = 0;i < list.size();i++){
			System.out.println(list.get(i).x);
		}
		
	}

	@Override
	public int compare(ArratListTest o1, ArratListTest o2) {
		// TODO Auto-generated method stub
		if(o1.x > o2.x)
			return 1;
		
		if(o1.x < o2.x)
			return -1;
		
		return 0;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
}
