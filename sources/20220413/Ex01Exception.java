import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex01Exception {

	public static void main(String[] args) {
		
		System.out.println("1");
		
		try {
			method();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		
		System.out.println("6");
	}
	
	public static void method() throws FileNotFoundException {
		
		System.out.println("2");
		
		try { //예외 발생이 의심되는 영역 설정 (이 영역에서 발생한 예외만 처리 가능)
			method2();
			//db 연결
			//db 데이터 읽기 //-> 오류
			//db 연결 종료 //-> 실행 보장 X
		} catch (ArithmeticException ex) { //extends RuntimeException
			System.out.println("산술 오류 정상 처리");
		} catch (ClassCastException ex) {
			System.out.println("형변환 오류 정상 처리");
		} catch (RuntimeException ex) {
			System.out.println("사용자 정의 오류 정상 처리");
		} catch (FileNotFoundException ex) {
			System.out.println("파일 없음 오류 정상 처리");
		} catch (Exception ex) {
			System.out.println("알 수 없는 오류 정상 처리");
		} finally {
			System.out.println("예외 여부와 관계 없이 실행");	
			// db 연결 종료
		}
		
		System.out.println("5");
	}
	
	public static void method2() throws FileNotFoundException {
		
		System.out.println("3");
		
		switch ( (int)(Math.random() * 8) ) { // 0 ~ 7
		//switch (5) {
		case 0 :
			int x = 10 / 0;// ArimethicException 예외가 발생하면 호출한 곳으로 보고
			break;
		case 1 :
			Object o = 10; //Integer
			String s = (String)o; //ClassCastException
			break;
		case 2 :
			RuntimeException ex = new RuntimeException("사용자 정의 예외");
			throw ex;//강제로 예외 발생	
		case 3 :
			FileInputStream fis = new FileInputStream("x.exe"); // FileNotFoundException ---> IOException
			break;
		}
		
		System.out.println("4");		
		
	}

}













