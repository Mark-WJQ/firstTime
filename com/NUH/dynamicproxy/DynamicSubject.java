package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicSubject implements InvocationHandler {
	//持有被代理对象
	private Object sub;
	
	public DynamicSubject(Object obj){
		this.sub = obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		
		System.out.println("before calling: "+method);
		method.invoke(sub, args);
		System.out.println("after calling: "+method);
		
		return null;
	}

}
