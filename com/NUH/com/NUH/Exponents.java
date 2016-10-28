package com.NUH;

import java.util.Random;

public class Exponents {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*float expFloat = 1.39e-43f;
		System.out.println(expFloat);
		double expDouble = 47e47d;
		double expDouble2 = 47e47;
		System.out.println(expDouble);
		System.out.println(Float.MAX_VALUE);*/
		/*for(int i=1;i<=100;i++){
			System.out.print(i+" ");
		}*/
		int i,j;
		for(int k=0;k<25;k++){
			Random random = new Random();
			i = random.nextInt();
			j = random.nextInt();
			if(i>j)
				System.out.print(1 + " ");
			else if(i<j)
				System.out.print(-1 + " ");
			else
				System.out.print(0 + " ");
		}
	}

}
