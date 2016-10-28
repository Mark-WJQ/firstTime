package com.NUH;

import java.util.TreeSet;

public class testSet {
	
	public static void main(String[] args) {
		
		TreeSet<person> ts = new TreeSet<person>();
		ts.add(new person(10));
		ts.add(new person(20));
		
		System.out.println(ts);
	}
	
	
	

}


class person{
	
	int score;

	public person(int score) {
		super();
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}