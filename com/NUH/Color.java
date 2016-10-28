
public enum Color{
	
	Red,White,Blue,Black("sss"),Yellow("aaa",2);
	
	
	private String value;
	private int x;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	Color(){
		
	}
	
	Color(String value){
		this.value = value;
	}
	
	Color(String value,int x){
		this.value = value;
		this.x = x;
	}
	
	public static void main(String[] args) {
		for(Color c : Color.values()){
			System.out.println(c.value);
		}
	}
	

}
