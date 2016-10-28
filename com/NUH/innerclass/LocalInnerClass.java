package innerclass;
/**
 * 局部类，在哪里定义在哪里使用
 * @author NUH-25
 *
 */
public class LocalInnerClass {

	public static void main(String[] args) {
		LocalInner inner = new LocalInner();
		inner.doSomething();
	}
}


class LocalInner{
	
	int b = 5;
	
	public void doSomething(){
		
		
		new Thread(){
			
		};
		
		final int a = 6;
		/*
		 * 局部类只能访问方法中final修饰的变量
		 */
		class Inner{
			public void test(){
				System.out.println("inner" + a + b);
			}
			
		}
		
		new Inner().test();
	}
	
	
	
	
	
	
}