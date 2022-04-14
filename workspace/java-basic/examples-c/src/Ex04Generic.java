
class TheObject {
	int a; // a 변수에는 정수만 저장할 수 있습니다.
	Object o; // 모든 자료형의 데이터를 저장할 수 있습니다.
}

class TheGeneric<E> { // 아직 확정되지 않은 E자료형을 사용하는 클래스 ( 변수 선언할 때 자료형 확정 )
	E o;
}

class TheGeneric2<E, O> {
	E a1;
	O a2;
	
	void m(E e, O o) {}
	E m2() { return null; }
	O m3() { return null; }
}

public class Ex04Generic {

	public static void main(String[] args) {
		
		TheObject obj1 = new TheObject();
		obj1.a = 10;
		// obj1.a = "Hello"; // a 변수는 정수만 저장할 수 있습니다.
		obj1.o = 100;
		obj1.o = "Hello"; // o 변수는 모든 자료형의 데이터를 저장할 수 있습니다.
		
		int a2 = obj1.a; // 자료형이 고정된 변수에서 데이터를 읽는 경우 형변환 불필요
		String s = (String)obj1.o; // Object에 저장된 변수를 읽을 때에는 형변환 필요
		// a2 = (int)obj1.o; // 형변환을 잘못하면 오류 발생
		
		System.out.printf("%d, %s\n", a2, s);
		
		//////////////////////////////////////////////
		
		TheGeneric<String> g = new TheGeneric<String>(); // 변수 만들때 자료형 결정
		g.o = "Hello";	
		String s2 = g.o; // g.o는 String 변수이기 때문에 형변환 불필요
		// g.o = 10; // 한 번 결정한 이후에는 변경할 수 없습니다.
		
		TheGeneric<Integer> g2 = new TheGeneric<Integer>();
		g2.o = 10;
		int a3 = g2.o; // 형변환 불필요
		

	}

}











