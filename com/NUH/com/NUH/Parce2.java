package com.NUH;

public class Parce2 {
	
	class Contents{
		private int i = 11;
		public int value(){
			return i;
		}
	}
	
	class Destination{
		private String lable;
		Destination(String whereTo){
			lable = whereTo;
		}
		
		String readLable(){
			return lable;
		}
	}
	
	
	public Destination to (String s){
		return new Destination(s);
	}
	
	public Contents contents(){
		return new Contents();
	}
	
	
	public void ship(String dest){
		Contents c = contents();
		Destination d = to(dest);
		System.out.println(d.readLable());
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parce2 p = new Parce2();
		p.ship("Tasmania");
		Parce2 q = new Parce2();
		Parce2.Contents c = q.contents();
		Parce2.Destination d = q.to("ddd");
		System.out.println(d.readLable());
	}

}
