
interface MyInterface {//자료형 (참조 변수 선언 가능, 객체 생성[new] 불가능)
	int X = 0; //인터페이스에 선언된 변수는 자동으로 static final (상수)
	void m(); // 인터페이스에는 본문이 없는 메서드만 선언 가능 (추상메서드)
}

class MyImplements //자료형 (참조 변수 선언 가능, 객체 생성[new] 가능)
	implements MyInterface { //인터페이스는 다른 클래스를 통해 구현되어 사용
	
	// 인터페이스 구현 클래스는 반드시 인터페이스의 메서드를 재정의
	@Override
	public void m() {
		System.out.println("This is method m");
	}
}

public class InterfaceReview {

	public static void main(String[] args) {
		
		int x; // 자료형(int) 변수(x)
		
		MyImplements b;
		b = new MyImplements();
		
		MyInterface a; // 자료형 (MyInterface) 변수(a)
		//a = new MyInterface(); // interface 타입은 객체 생성 불가능 (new X)
		
		//전형적인 인터페이스 사용 형태
		// - 참조는 인터페이스 타입, 인스턴스는 클래스 타입
		MyInterface c = new MyImplements();

	}

}







