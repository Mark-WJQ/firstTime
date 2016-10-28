package observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreatedWatched implements Watched {

	private List<Watcher> list = new ArrayList<Watcher>();
	
	@Override
	public void addWatcher(Watcher watcher) {
		// TODO Auto-generated method stub
		list.add(watcher);

	}

	@Override
	public void removeWatcher(Watcher watcher) {
		// TODO Auto-generated method stub
		list.remove(watcher);
	}

	@Override
	public void notifyWatcher(String str) {
		// TODO Auto-generated method stub
		for(Watcher watcher : list){
			watcher.update(str);
			
		}
	}

}
