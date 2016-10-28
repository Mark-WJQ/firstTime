package com.NUH;

public class NodeTest {

	public static void main(String[] args) {
		Node n3 = new Node("c",null);
		Node n2 = new Node("b",n3);
		Node n1 = new Node("a",n2);
		Node n4 = new Node("d",null);
		
		n2.next = n4;
		n4.next = n3;
		
		System.out.println(n2.next.item);
		
	}
	
}


class Node {
	String item;
	Node next;
	public Node(String item,Node next) {
		super();
		// TODO Auto-generated constructor stub
		this.item = item;
		this.next = next;
		
	}
	
	
	
}