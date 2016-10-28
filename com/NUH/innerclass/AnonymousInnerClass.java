package innerclass;

import java.util.Date;

public class AnonymousInnerClass {
	
	@SuppressWarnings("deprecation")
	public String get(Date date){
		return date.toLocaleString();
	}


	public static void main(String[] args){
		AnonymousInnerClass anonymousInnerClass = new AnonymousInnerClass();
		String str = anonymousInnerClass.get(new Date(){});
		System.out.println(str);
		
		
		Thread thread = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(1);
			}
		};
		
		thread.start();
	}
}
