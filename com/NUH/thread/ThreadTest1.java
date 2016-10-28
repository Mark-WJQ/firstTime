package thread;

public class ThreadTest1 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Thread1(), "t1");
		Thread t2 = new Thread(new Thread1(), "t2");
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		t1.start();
		t2.start();
		
	}
	
}



class Thread1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("hello world");
	}
	
}

class Thread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("hello world");
	}
	
}