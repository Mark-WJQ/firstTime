package observer;

import java.util.Observable;

public class BeObserver extends Observable {
	
	int [] a;
	
	public BeObserver(int ...is){
		super();
		this.a = is;
	}
	
	
	
	public void setNumner(){
		for(int i = 0; i < a.length ; i++){
			this.setChanged();
			this.notifyObservers(a[i]);
		}
	}
	

}
