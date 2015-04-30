package day02_exception;

public class ExceptionTest {
	public static void main(String[] args) {
		int a = 0;
		double b;
		
		try{
			b = 100 / a; // java.lang.ArithmeticException 발생
		}catch(ArithmeticException e){
			//e.printStackTrace();
			System.out.println("예외가 발생하였습니다. 프로그램을 종료합니다.");
			return;
			//return 하면 Some more codes 안찍힌다.
		}finally{
			System.out.println("자원정리");
		}
		System.out.println("Some more codes"); // 예외 발생으로 수행되지 않음
	}

}
