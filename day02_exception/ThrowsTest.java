package day02_exception;

import java.io.IOException;

public class ThrowsTest {

	public void suspiciousMethod() throws IOException {
		// CheckedException -> Exception 상속
		// 컴파일 할 때 확인되는 Exception
		throw new IOException();	// 강제로 예외 발생
	}
	
	public void suspiciousMethod2() throws DivideByZeroException {
		// UncheckehException -> RuntimeException 상속
		// 실행 시점에 확인되는 Exception
		throw new DivideByZeroException();	// 강제로 예외 발생
	}
	
	public void suspiciousMethod3() throws DivideByZeroException {
		throw new DivideByZeroException();
	}
	
}
