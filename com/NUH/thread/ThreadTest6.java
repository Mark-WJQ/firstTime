package thread;

public class ThreadTest6 {
	public static void main(String[] args) throws InterruptedException {
		NumberTest bank = new NumberTest();
		MyThread7 t1 = new MyThread7(bank);
		MyThread5 t2 = new MyThread5(bank);
		t1.start();
		t2.start();
		System.out.println(bank.money );
		
	}
}


class NumberTest{
	
	int money = 1000;
	public synchronized int getMoney(int number){
		if(money < 0 ){
			return -1;
		}else if(number > money){
			return -2;
		}else{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			money = money - number;
			return number;
		}
	}
	
	
	
	public synchronized int addMoney(int number){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		money = money + number;
		return number;
	}
	
	
}



class MyThread7 extends Thread{
	
	public NumberTest bank;
	
	public MyThread7(NumberTest bank){
		this.bank = bank;	
	}
	
	@Override
	public void run(){
		System.out.println(bank.getMoney(800));
	}
}


class MyThread5 extends Thread{
	
	public NumberTest bank;
	
	public MyThread5(NumberTest bank){
		this.bank = bank;	
	}
	
	@Override
	public void run(){
		System.out.println(bank.addMoney(200));
	}
}

