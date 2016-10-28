package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

public class VectorProxy implements InvocationHandler {

	
	private Object proxyObj;
	
	public VectorProxy(Object obj) {
		// TODO Auto-generated constructor stub
		this.proxyObj = obj;
	}
	
	public static Object factory(Object obj){
		Class<?> classType = obj.getClass();
		return Proxy.newProxyInstance(classType.getClassLoader(), classType.getInterfaces(), new VectorProxy(obj));
		
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before calling: " +method);
		if(args != null){
			for(Object obj : args){
				System.out.println(obj);
			}
		}
		
		return method.invoke(proxyObj, args);
	}
	
	
	public static void main(String[] args) {
		List<String> v = (List<String>) factory(new Vector<String>());
		v.add("New");
		v.add("York");
		
		v.remove(0);
	}
	
	

}
