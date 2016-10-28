package thread;

public class ThreadTest3 {

	public static int i = 1000;
	
	public void add(){
		System.out.println(i ++);
	}
	
	public synchronized void sub(){
		i = i - 800;
		System.out.println(i);
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadTest3 tt = new ThreadTest3();
		MyThread3 mt3 = new MyThread3(tt);
		MyThread4 mt4 = new MyThread4(tt);
		
		Thread t1 = new Thread(mt3);
		Thread t2 = new Thread(mt4);
		//Thread.sleep(1000);
		t1.start();
		System.out.println(t1.getName());
		t2.start();
		System.out.println(t2.getName());
	}
}



class MyThread3 implements Runnable{
	
	private ThreadTest3 tt;
	
	public MyThread3(ThreadTest3 tt){
		this.tt = tt;
	}
	
	public void run() {
		if(ThreadTest3.i > 800){
			tt.sub();	
		}
	}
}



class MyThread4 implements Runnable{
	private ThreadTest3 tt;
	
	public MyThread4(ThreadTest3 tt){
		this.tt = tt;
	}
	public void run() {
		if(ThreadTest3.i > 800){
			tt.sub();
		}
	}
}