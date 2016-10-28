package observer;

import java.util.Observable;
import java.util.Observer;

public class Observer2 implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if((int)arg < 5){
			System.out.println((int)arg);
		}
	}

}
