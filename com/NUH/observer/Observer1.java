package observer;

import java.util.Observable;
import java.util.Observer;

public class Observer1 implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println((int)arg);
	}

}
