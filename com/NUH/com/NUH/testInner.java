package com.NUH;

import java.util.Random;

public class testInner {

	    public static long OUTER_DATE = System.currentTimeMillis();
	    public static int a = 1;
	    static {
	        System.out.println("外部类静态块加载时间：" + System.currentTimeMillis());
	    }

	    public testInner() {
	        //timeElapsed();
	        System.out.println("外部类构造函数事件：" + System.currentTimeMillis());
	    }

	    static class InnerStaticClass {
	        static {
	            System.out.println("内部类静态块加载时间：" + System.currentTimeMillis());
	        }
	        public static long INNER_STATIC_DATE = System.currentTimeMillis();

	    }
	    public static int tset(){
			return 0;
	    }
	    class InnerClass {
	        public long INNER_DATE = 0;
	        public InnerClass() {
	            timeElapsed();
	            INNER_DATE = System.currentTimeMillis();
	        }           
	    }

	    public static void Hello(){System.out.println("Hello");}

	    public static void main(String[] args) {
	    	System.out.println("调用静态方法!"+testInner.tset());
	        //System.out.println("内部类静态变量加载时间：" + InnerStaticClass.INNER_STATIC_DATE );
	       // System.out.println("外部类静态变量加载时间：" + testInner.OUTER_DATE );
	    }

	   
	    
	    //单纯的为了耗时而已
	    private void timeElapsed() {
	        for (int i = 0; i < 10000000; i++) {
	            int a = new Random(100).nextInt(), b = new Random(100).nextInt();
	            a = a + b;
	        }
	    }
	

}
