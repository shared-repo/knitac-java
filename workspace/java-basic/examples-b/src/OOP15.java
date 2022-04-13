
// abstract class 
// : 인스턴스 생성 불가능 클래스 ( new 연산자 적용 X )
// : 참조 변수를 만드는 것은 가능
abstract class TheAbstract {
	
	// abstract method : 본문이 없는 메서드 ( { ... } 가 없는 메서드, 미완성 메서드 )
	// abstract method를 포함하는 클래스는 반드시 abstract class로 만들어야 합니다.
	abstract void m();
	
	// non abstract 멤버 포함 가능
	int x;
	void m2() {
		System.out.println("메서드의 내용입니다.");
	}
	
}

// 추상클래스는 다른 클래스에 의해 상속되어 사용됩니다.
// 추상클래스를 상속하는 클래스는 반드시 상속받은 추상메서드를 완성(재정의, override)해야 합니다.
class TheConcrete extends TheAbstract {

	@Override
	void m() {		
	}
	
}

public class OOP15 {

	public static void main(String[] args) {
		
		// 1.
		// TheAbstract obj1 = new TheAbstract(); // 추상클래스는 인스턴스 생성 X
		
		// 2. 참조변수는 추상클래스타입, 인스턴스는 상속받은 구현클래스타입으로
		TheAbstract c = new TheConcrete();

	}

}
