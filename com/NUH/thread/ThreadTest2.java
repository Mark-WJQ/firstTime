package thread;

public class ThreadTest2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		/*Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		t2.start();
		Thread.sleep(5000);
		t1.start();*/
		HelloThred ht = new HelloThred();
		Thread t3 = new Thread(ht);
		Thread t4 = new Thread(ht);
		t3.start();
		t4.start();
		
	}
	
	

}


class HelloThred implements Runnable{
	
	
	int i;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
		System.out.println("number :" + i++);
		
			try {
				Thread.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(50 == i){
				break;
			}
		}
	}
	
}



class MyThread1 extends Thread{
	
	@Override
	public void run(){
		System.out.println("welcome");
	}
	
}

class MyThread2 extends Thread{
	
	@Override
	public void run(){
		System.out.println(System.in);
	}
	
}