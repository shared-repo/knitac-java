
// interface는 자료형 -> 변수를 만들 수 있습니다.
// 극단적인 추상클래스 -> 모든 멤버가 추상메서드
// 필드를 포함하는 경우 static final
// 인스턴스 만들 수 없지만, 참조 변수는 만들 수 있습니다.
interface BaseInterface {
	int STATIC_FIELD = 10; // -> public static final STATIC_FIELD = 10
	void m(); // -> public abstract void m();
}

// 인터페이스는 다른 클래스를 통해 완성되고 사용할 수 있게 됩니다.
class TheImplement implements BaseInterface {

	@Override
	public void m() {	
		
	}
	
}

public class OOP16 {

	public static void main(String[] args) {
		
		// 1. 
		// BaseInterface i1 = new BaseInterface(); 인터페이스의 인스턴스를 만들 수 없습니다.

		// 2. 인터페이스 참조변수 = 구현클래스의 인스턴스 방식으로 사용
		BaseInterface i1 = new TheImplement();

	}

}
