package junit;

import org.junit.Test;

public class Test4 {
	/**
	 * 注解流程    通过反射
	 * 首先获取 待测试类Class对象
	 * 然后通过该Class对象获取所有public方法
	 * 判断该方法是否有test注解
	 * true method.invoke();
	 * 
	 */
	
	@Test
	public void hello(){
		System.out.println("hello world");
	}
	
}
