package com.NUH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;




public class Person {
	
	
	
	
	
	

	private int id;
	private String name;
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public static void main(String[] args) {
		
		Random random = new Random();
		Person p1 = new Person(random.nextInt(100), "sssss", random.nextInt());
		Person p2 = new Person(random.nextInt(100), "aasss", random.nextInt());
		Person p3 = new Person(random.nextInt(100), "sddss", random.nextInt());
		Person p4 = new Person(random.nextInt(100), "ffss", random.nextInt());
		Person p5 = new Person(random.nextInt(100), "wwss", random.nextInt());
		Person p6 = new Person(random.nextInt(100), "sdds", random.nextInt());
		Person p7 = new Person(random.nextInt(100), "wwsss", random.nextInt());
		Person p8 = new Person(random.nextInt(100), "qqsss", random.nextInt());
		
		List<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		list.add(p7);
		list.add(p8);
		
		
		
		Environment env = new Environment();
		env.setPersonSort(new SortById());
		env.sortASC(list);
		for(Person p : list){
			System.out.println(p);
		}
	}
	
	
}



interface PersonSort{
	void sortDESC(List<Person> list);
	void sortASC(List<Person> list);
}


class SortById implements PersonSort{


	@Override
	public void sortDESC(List<Person> list) {
		// TODO Auto-generated method stub
		Collections.sort(list,new PersonCompareByIdDESC<Person>());
	}

	@Override
	public void sortASC(List<Person> list) {
		// TODO Auto-generated method stub
		Collections.sort(list, new PersonCompareByIdASC<Person>());
	}
	
}


//降序
class PersonCompareByIdDESC<Person> implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		// TODO Auto-generated method stub
		return	((com.NUH.Person) p2).getId() -((com.NUH.Person) p1).getId();
		//return 0;
	}
	
}

//升序
class PersonCompareByIdASC<Person> implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		// TODO Auto-generated method stub
		return	((com.NUH.Person) p1).getId() -((com.NUH.Person) p2).getId();
	}
	
}


class  Environment{
	PersonSort personSort;
	
	public Environment(){};
	
	public Environment(PersonSort personSort){
		personSort = this.personSort;
	}

	public void setPersonSort(PersonSort personSort) {
		this.personSort = personSort;
	}
	
	public void sortASC(List<Person> list){
		this.personSort.sortASC(list);
	}
	
	public void sortDESC(List<Person> list){
		this.personSort.sortDESC(list);
	}
	
}

