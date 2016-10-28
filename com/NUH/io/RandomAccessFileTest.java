package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	
	
	public static void main(String[] args) throws IOException {
		
		
		Person p = new Person(10, "jjj", 12.5);
		RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
		p.wtite(raf);
		
		Person p1 = new Person();
		raf.seek(0);
		p1.read(raf);
		
		
		System.out.println(p1.getId() +"   "+p1.getName() +"    "+p1.getHeight());
		
	}
	

}



class Person{
	int id;
	String name;
	double height;
	
	
	
	
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getHeight() {
		return height;
	}

	public Person(){
		
	}
	
	public Person(int id,String name,double height){
		this.id = id;
		this.name = name;
		this.height = height;
	}
	
	public void wtite(RandomAccessFile raf) throws IOException{
		raf.writeInt(id);
		raf.writeUTF(name);
		raf.writeDouble(height);
		
	}
	
	public void read(RandomAccessFile raf) throws IOException{
		this.id = raf.readInt();
		this.name = raf.readUTF();
		this.height = raf.readDouble();
	}
	
}
