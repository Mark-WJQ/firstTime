package io;

public class Test1 {
	
	
	
	/**
	 * 	阶乘
	 * 
	 *   n! = n*(n-1)*(n-2)*....*1;
	 *   n! = n*(n-1)!
	 *   (n-1)! = (n-1)*(n-2)!
	 *   递归运算  
	 * 
	 * 
	 * @param i
	 * @return
	 */
	
	
	public static int compute(int i){
		if(i == 1)
			return 1;
		return i*compute(i-1);
	}
	
	/**
	 * 斐波那契数列
	 * 1 ,1 ,2,3,5,8,13
	 * 
	 * 
	 * 
	 * 
	 * @param i
	 * @return
	 */
	public static int fabCompute(int i){
		if(i == 1 || i == 2)
			return 1;
		else
			return fabCompute(i-1) + fabCompute(i-2);
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println(compute(5));
		System.out.println(fabCompute(9));
	}
	

}
