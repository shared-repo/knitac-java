
class Person2 {	
	String name;
	String phone;
	String email;
	
	String info() {		
		// String.format : System.out.printf와 동일한 기능 ( 단, 출력 기능만 생략 )		
		String s = String.format("[%s][%s][%s]", name, phone, email); 
		return s;
	}
}

public class OOP02 {

	public static void main(String[] args) {
		int a = 10;
		int b = a;
		System.out.printf("[%d][%d]\n", a, b); // 10, 10
		b = 20;
		System.out.printf("[%d][%d]\n", a, b); // 10, 20
		
		Person2 p1 = new Person2();
		p1.name = "John Doe";
		p1.phone = "010-6523-7854";
		p1.email = "johndoe@example.com";		
		System.out.println(p1.info());
		
		Person2 p2 = p1;	// 참조변수의 복사는 주소 복사 -> 두 참조 변수는 같은 인스턴스를 참조
		p2.name = "Jane Doe";	// 같은 주소를 참조하기때문에 p2로 인스턴스 조작하면 p1도 영향을 받습니다.
		p2.phone = "010-1234-5678";
		p2.email = "janedoe@example.com";		
		System.out.println(p1.info()); // 출력 ?
	}

}











