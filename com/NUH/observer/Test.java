package observer;

import java.util.Observable;

public class Test {

	public static void main(String[] args) {
	
		int[] a = new int[]{10,9,8,7,6,5,4,3,2,1}; 
		BeObserver beObserver = new BeObserver(a);
		beObserver.addObserver(new Observer1());
		beObserver.addObserver(new Observer2());
		beObserver.setNumner();
		
		Watched girl = new ConcreatedWatched();
		
		Watcher w1 = new ConcreatedWatcher();
		Watcher w2 = new ConcreatedWatcher();
		Watcher w3 = new ConcreatedWatcher();
		
		girl.addWatcher(w1);
		girl.addWatcher(w2);
		girl.addWatcher(w3);
		girl.notifyWatcher("ddddd");
		
		girl.removeWatcher(w2);
		girl.notifyWatcher("ddddd");
	}
	
	
}
