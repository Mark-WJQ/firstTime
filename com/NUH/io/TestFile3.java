package io;

import java.io.File;
import java.io.FilenameFilter;

public class TestFile3 {

	public static void main(String[] args) {
		File file = new File("E:/workspace_juno/testProject/src/com/NUH");
		
		String[] names = file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				if(name.endsWith(".java"))
					return true;
				return false;
			}
		});
		for(String name : names){
			System.out.println(name);
		}
	}
}
