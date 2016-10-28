package thread;

public class Sample {
	
	
	
	public static void main(String[] args) {
		
		Sample sample = new Sample();
		
		Thread t1 = new IncreaseThread(sample);
		Thread t2 = new IncreaseThread(sample);
		Thread t3 = new DecreaseThread(sample);
		Thread t4 = new DecreaseThread(sample);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	
	
	
	
	
	private int number;
	
	
	public synchronized void decrease(){
		
		while(0 == number){
			try {
				notify();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		number --;
		System.out.print(Thread.currentThread().getName() + number);
		
		notify();
	}
	
	public synchronized void increase(){
		while(0 != number){
			try {
				notify();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		number++;
		System.out.print(Thread.currentThread().getName() + number);
		notify();
	}

}


class IncreaseThread extends Thread{
	private Sample sample;
	
	public IncreaseThread(Sample sample){
		this.sample = sample;
	}

	@Override
	public void run() {
		for(int i = 0; i < 20 ; i++){
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			sample.increase();
		}
	}
}


class DecreaseThread extends Thread{
	private Sample sample;
	
	public DecreaseThread(Sample sample){
		this.sample = sample;
	}
	
	
	@Override
	public void run() {
		
		for(int i = 0; i < 20 ; i++){
			/*try {
				Thread.sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			sample.decrease();
			
		}
	}
}



