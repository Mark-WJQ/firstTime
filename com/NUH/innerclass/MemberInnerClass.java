package innerclass;



public class MemberInnerClass {
	public static void main(String[] args) {
		MemberInner memberInner = new MemberInner();
		memberInner.new Inner();
		MemberInner.Inner inner = new MemberInner().new Inner();
		inner.doSomeThing();
	}
	
	

}


class MemberInner{
	
	private int a = 4;
	
	public void test(){
		Inner inner = new Inner();
		inner.doSomeThing();;
	}
	
	
	public class Inner{
		private int a = 5;
		public void doSomeThing(){
			MemberInner memberInner = new MemberInner();
			System.out.println(memberInner.a);
			System.out.println(MemberInner.this.a);
		}
		
	}
	
	
}