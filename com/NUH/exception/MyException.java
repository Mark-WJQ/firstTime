package exception;

@SuppressWarnings("serial")
public class MyException extends Exception {

	
	public MyException() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public MyException(String mesage) {
		// TODO Auto-generated constructor stub
		super(mesage);
	}
	
	
	public MyException(Throwable cause) {
		// TODO Auto-generated constructor stub
		super(cause);
	}
	
	 public MyException(String str, Throwable nested) {
	        super(str, nested);
	    }
}
