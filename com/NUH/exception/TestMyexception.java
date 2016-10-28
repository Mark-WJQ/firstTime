package exception;

public class TestMyexception {

	public void method(String str) throws MyException{
		if(null == str)
			throw new MyException("");
	}
	
}
