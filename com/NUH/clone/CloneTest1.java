package clone;

public class CloneTest1 {
	
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		
		Teacher teacher = new Teacher();
		teacher.setAge(80);
		teacher.setName("i'm teacher");
		Student student = new Student();
		student.setTeacher(teacher);
		student.setAge(20);
		student.setName("nnnn");
		Student student2 = (Student) student.clone();
		
		System.out.println(student2.getAge());
		System.out.println(student2.getName());
		System.out.println(student2.getTeacher().getName());
		
		
		System.out.println("-------------------------------");
		
		student.setName("qqqq");
		teacher.setName("wang");
		System.out.println(student2.getName());
		System.out.println(student.getName());
		System.out.println(student2.getTeacher().getName());
		System.out.println(student.getTeacher().getName());
		
	}

	
}



class Student implements Cloneable{
	 private int age;
	 private String name;
	 
	 private Teacher teacher;
	 
	 
	 
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
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
	
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	 
}


class Teacher implements Cloneable{
	
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
	
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}

