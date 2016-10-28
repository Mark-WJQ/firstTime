package com.NUH;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/*public final class Directory{
	
	
	 public static File[] local(File dir,final String regex){
	    	return dir.listFiles(new FilenameFilter() {
	    		private Pattern pattern = Pattern.compile(regex);
				
				@Override
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					return pattern.matcher(new File(name).getName()).matches();
				}
			});
	    }
	    
	    public static File[] local(String path,final String regex){
	    	return local(new File(path), regex);
	    }
	    
}*/

public class TreeInfo implements Iterable<File> {
	
	public static String pformat(Collection<?> c){
		if(c.size() == 0) return "[]";
		StringBuilder result = new StringBuilder("[");
		for(Object elem : c){
			if(c.size() != 1){
				result.append(elem);
			}
			result.append("\n");
		}
		if(c.size() != 1){
			result.append("\n");
		}
		result.append("]");
		return result.toString();
	}
	
	
	public static void pprint(Collection<?> c){
		pformat(c);
	}
	
	
	public List<File> files = new ArrayList<File>();
	public List<File> dirs = new ArrayList<File>();
	
	@Override
	public Iterator<File> iterator() {
		// TODO Auto-generated method stub
		return files.iterator();
	}
	
	
	void addAll(TreeInfo other){
		files.addAll(other.files);
		dirs.addAll(other.files);
	}
	
	public static TreeInfo walk(String start,String regex){
		return recurseDirs(new File(start), regex); 
	}
	public String toString(){
		return "dirs: " + pprint(dirs) + 
				"\n\nfiles: "+ pprint(files);
	}
	public static TreeInfo walk(File start,String regex){
		return recurseDirs(start, regex); 
	}

	public static TreeInfo walk(File start){
		return recurseDirs(start,".*"); 
	}
	
	public static TreeInfo walk(String start){
		return recurseDirs(new File(start),".*"); 
	}
	static TreeInfo recurseDirs(File startDir,String regex){
		TreeInfo result = new TreeInfo();
		for(File item : startDir.listFiles()){
			if(item.isDirectory()){
				result.dirs.add(item);
				result.addAll(recurseDirs(item, regex));
			}else{
				if(item.getName().matches(regex)){
					result.files.add(item);
				}
			}
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(walk("D:\360Downloads"));
	}

	

}