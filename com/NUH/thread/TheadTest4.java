package thread;

public class TheadTest4 {

	
	public static void main(String[] args) throws InterruptedException {
		Bank bank = new Bank();
		myThread t1 = new myThread(bank);
		myThread t2 = new myThread(bank);
		t1.start();
		t2.start();
	}
	
}


class Bank{
	
	int money = 1000;
	public synchronized int getMoney(int number){
		if(money < 0 ){
			return -1;
		}else if(number > money){
			return -2;
		}else{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			money = money - number;
			return number;
		}
	}
	
}



class myThread extends Thread{
	
	public Bank bank;
	
	public myThread(Bank bank){
		this.bank = bank;	
	}
	
	@Override
	public void run(){
		System.out.println(bank.getMoney(800));
	}
}
