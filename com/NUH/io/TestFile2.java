package io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * 递归首先要找的条件事结束的条件
 * 
 * 
 * 
 * @author NUH-25
 *
 */


public class TestFile2 {
	
	
	
	
	
	
	
	
	//表示文件深度
	static int count = 0;
	public static void main(String[] args) {
		File file = new File("E:/workspace_juno/testProject/src/com/NUH");
		getAllFile(file);
		//System.out.println(count);
		/*File[] files = file.listFiles();
		for(File f : files){
			System.out.println(f.getName());
		}*/
	}
	public static void getAllFile(File file){		
		
		if(file.isFile() || 0 == file.list().length){
			outPuttab(count);
			System.out.println(file.getName());
		}else{
			File[] files = sortFile(file).toArray(new File[0]);
			outPuttab(count);
			System.out.println(file.getName());
			for(File f : files){	
				//
				count ++;
				getAllFile(f);
				count --;
			}
		}	
	}
	
	
	
	public static void outPuttab(int i){
		for(int k = 0; k < i ; k++){
			System.out.print(" ");
		}
	}
	
	
	public static List<File> sortFile(File file){
		List<File> list = new ArrayList<File>(file.listFiles().length);
		File[] files1 = file.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				if(pathname.isDirectory())
					return true;
				return false;
			}
		});
		//list.addAll(Arrays.asList());
		
		for(File f : files1){
			list.add(f);
		}
		File[] files = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				if(pathname.isFile())
					return true;
				return false;
			}
		});
		for(File f : files){
			list.add(f);
		}
		
		return list;
	}
	
	
}
