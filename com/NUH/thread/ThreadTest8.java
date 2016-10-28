package thread;


public class ThreadTest8 {
	
	String name;
	
	public static void main(String[] args) throws InterruptedException {
		person tt8 = new person();
		tt8.name = new String("ang");
		
		TestString ts1 = new TestString();
		ts1.setperson(tt8);
		
		person tt81 = new person();
		tt81.name = new String("ang");
		
		TestString ts2 = new TestString();
		ts2.setperson(tt81);
		
		ts1.start();
		ts2.start();
	}
	
}



class person{
	
	static String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void outString() throws InterruptedException{
		synchronized(name){
			if("Thread-0".equals(Thread.currentThread().getName())){
				Thread.sleep(5000);
			}
			System.out.println(Thread.currentThread().getName());
		}
		
		System.out.println(Thread.currentThread().getName() + "hahahahahha");
	}
	
}


class TestString extends Thread{
	
	
	private person tt8;
	

	public void setperson(person tt8) {
		this.tt8 = tt8;
	}


	@Override
	public void run() {
		
		try {
			person.outString();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}