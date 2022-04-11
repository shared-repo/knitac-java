
class Person5 {

	public String name;
	private String phone;
	private String email;
	
	// 생성자 메서드 ( constructor ) : 인스턴스 초기화 도구
	// 1. 형식 : 결과형 X, 이름은 클래스이름과 동일
	public Person5() {
		System.out.println("전달인자 없는 생성자 메서드");
	}
	// 2. instance가 만들어질때 (new 할때 ) 자동 호출
	// 3. overloading 가능 : 전달인자를 다르게 해서 여러 개의 생성자 메서드 정의할 수 있습니다.
	public Person5(String name, String phone, String email) {
		System.out.println("전달인자 있는 생성자 메서드");
		this.name = name;	// 전달인자로 인스턴스 멤버의 값 초기화
		this.phone = phone;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String info() {	
		String s = String.format("[%s][%s][%s]", name, phone, email);  // 내부 접근
		return s;
	}
}

public class OOP05 {

	public static void main(String[] args) {
		
		int x = 10; // 초기화 ( 변수를 만들면서 값 저장 )
		int[] ar = { 1, 2, 3, 4, 5 }; // 초기화 ( 배열을 만들면서 값 저장 )
		// 인스턴스 초기화 ?
		
		// 전달인자 없는 생성자 메서드 호출
		Person5 p = new Person5(); 
		
		// 전달인자 있는 생성자 메서드 호출
		Person5 p2 = new Person5("장동건", "010-6541-9874", "jdk@example.com");
		System.out.println(p2.info());
	}

}











