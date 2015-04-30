package day02_exception;

import java.io.IOException;

public class ThrowsTest2 {

	public static void main(String[] args) {

		ThrowsTest tt = new ThrowsTest();

		// UncheckedException
		try {
			tt.suspiciousMethod2();
		} catch (DivideByZeroException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// CheckedException -> UnHandled Exception
//		try {
//			tt.suspiciousMethod();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
