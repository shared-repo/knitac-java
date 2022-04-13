
// 자바의 모든 클래스는 직접 또는 간접적으로 Object 클래스를 상속합니다.
class NewMyClass /* extends Object */ { // extends Object가 생략되어 있습니다.
	int x;
	String s;

	// Object.toString : 객체의 정보를 간단한 문자열로 반환하는 메서드
	@Override
	public String toString() {
		return String.format("[%d][%s]", x, s);
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof NewMyClass == false) {	// 같은 자료형인지 확인
//			return false;
//		}
//		NewMyClass other = (NewMyClass)obj;
//		if (this.x == other.x && this.s.equals(other.s)) { // 내용을 비교하도록 구현
//			return true;
//		} else {
//			return false;
//		}
//	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof NewMyClass == false) {	// 같은 자료형인지 확인
			return false;
		}
		NewMyClass other = (NewMyClass)obj;
		return ( this.x == other.x && this.s.equals(other.s) );
	}
	
	@Override
	public int hashCode() { // 인스턴스를 고유하게 구분하는 정수 값, 기본 구현은 주소 반환
		return x;
	}
}
public class OOP14 {
	public static void main(String[] args) {
		// 1. Object 상속 확인
		NewMyClass obj = new NewMyClass();
		obj.toString(); // 정의 하지 메서드를 사용할 수 있는 것은 Object에서 상속받았기 때문
		Object obj2 = new NewMyClass(); // 참조변수를 Object로 할 수 있는 것은 상속 받았기 때문
		
		// 2. toString test
		NewMyClass obj3 = new NewMyClass();
		obj3.x = 100;
		obj3.s = "toString test !!!!";
		System.out.println(obj3); // 대개의 경우 문자열이 필요한 상황이면 자동으로 toString() 호출
		
		// 3. eqauls test
		NewMyClass obj4_1 = new NewMyClass();
		obj4_1.x = 10;
		obj4_1.s = "equals test";
		NewMyClass obj4_2 = new NewMyClass();
		obj4_2.x = 10;
		obj4_2.s = "equals test";
		
		if (obj4_1 == obj4_2) { // 비교연산자는 항상 주소(참조) 비교
			System.out.println("== 같습니다.");
		} else {
			System.out.println("== 다릅니다.");
		}
		
		if (obj4_1.equals(obj4_2)) { // equals의 기본 구현은 주소(참조) 비교, 재정의 가능
			System.out.println("equals 같습니다.");
		} else {
			System.out.println("equals 다릅니다.");
		}
	}

}






