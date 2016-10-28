package innerclass;

public class StaticInnerClass {
	
	private static int a = 4;
	
	public static class inner{
		int b = a;
		
		public void output(){
			System.out.println(b);
		}
		
	}

	public static void main(String[] args) {
		StaticInnerClass.inner name = new inner();
		name.output();
	}
	
	
}
