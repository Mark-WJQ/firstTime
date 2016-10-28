package proxy;

public class ProxySubject extends Subject {

	private RealSubject realSubject;    //代理角色内部引用真实角色
	
	@Override
	public void request() {
		// TODO Auto-generated method stub
		if(null == realSubject){
			realSubject = new RealSubject();
		}
		preRequest();//真实自角色操作之前代理附加的操作
		realSubject.request();
		postRequest();//真实角色操作之后代理附加的操作
	}
	
	private void preRequest(){
		System.out.println("pre request");
	}

	private void postRequest(){
		System.out.println("post request");
	}
}
