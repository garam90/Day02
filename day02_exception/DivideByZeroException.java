package day02_exception;

public class DivideByZeroException extends Exception {

	public DivideByZeroException(){
		super("Dividing By 0");
	}
	public DivideByZeroException(String str){
		super(str);
	}
	
	public void DivideByZeroException2(){
		throw new ArithmeticException();	// 강제로 예외 발생
	}
	
}
