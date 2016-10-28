package com.NUH;

public class StringOperators {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0,y = 1,z = 2;
		String s = "x,y,z";
		System.out.println(s+x+y+z);
		System.out.println(x+""+y);
		s += "(summed) = ";
		System.out.println(s+(x+y+z));
		System.out.println("" + x);
	}

}
/*
 * x,y,z012
01
x,y,z(summed) = 3
0
 * */
