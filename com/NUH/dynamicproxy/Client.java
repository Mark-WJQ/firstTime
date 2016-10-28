package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		RealSubject realSubject = new RealSubject();
		//构造代理
		InvocationHandler handler = new DynamicSubject(realSubject);
		Class<?> classType = handler.getClass();
		//下面代码一次性生成代理
		
		Subject sub = (Subject) Proxy.newProxyInstance(classType.getClassLoader(), realSubject.getClass().getInterfaces(), handler);
		sub.request();
		//打印新生成的类
		System.out.println(sub.getClass());
	}
	
}
