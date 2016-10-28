package clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;


/**
 * 
 * 深克隆
 * 
 * @author NUH-25
 *
 */

public class CloneTest2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Teacher1 t1 = new Teacher1();
		t1.setAge(50);
		t1.setName("wang");
		
		Student1 s1 = new Student1();
		s1.setAge(20);
		s1.setName("li");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(s1);
		
		ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		Student1 s2 =  (Student1) ois.readObject();
		s1.setAge(30);
		System.out.println(s2.getAge());
		
	}
	
}



class Student1 implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Teacher1 teacher1;
	
	public Teacher1 getTeacher1() {
		return teacher1;
	}
	public void setTeacher1(Teacher1 teacher1) {
		this.teacher1 = teacher1;
	}
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Student1 deepClone(Student1 s) throws IOException, ClassNotFoundException{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(this);
		ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		Student1 s2 =  (Student1) ois.readObject();
		return s2;
	}
	
	
}


class Teacher1 implements Serializable{
	
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
