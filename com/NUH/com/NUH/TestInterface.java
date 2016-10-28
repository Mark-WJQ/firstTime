package com.NUH;

public class TestInterface implements AA{

	static int a = 10;
	
	
	static{
		
		System.out.println("22222");
	}
	
	@Override
	public void testoutput() {
		// TODO Auto-generated method stub
		System.out.println("ccc");
	}
	
	public static void main(String[] args){
		//TestInterface ti = new TestInterface();
		//ti.testoutput();
		AA aa = new BB();
		BB bb = (BB) aa;
		bb.o();
		//ti.a = 8;
		//System.out.println(ti.a);
		
		//TestInterface ti1 = new TestInterface();
		//System.out.println(ti1.a);
		System.out.println(TestInterface.a);
		
		
	}
}


interface AA {
	int i = 0;
	public void testoutput();
	
	abstract public void test1();
	
	
}



abstract class BB implements AA{

	@Override
	public void testoutput() {
		// TODO Auto-generated method stub
		System.out.println("iii");
	}
	
	public void o(){
		System.out.println("oo");
	}
	
}