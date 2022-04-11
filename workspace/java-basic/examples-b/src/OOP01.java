
public class OOP01 {

	public static void main(String[] args) {
		
		// int a
		Person person = null;	// Person 타입의 참조 변수
		person = new Person();	// Person 타입의 인스턴스 만들기 + 참조 변수에 주소(참조) 저장
		
		person.name = "John Doe";
		person.phone = "010-6523-7854";
		person.email = "johndoe@example.com";
		
		String personInfo = person.info();
		System.out.println(personInfo);
		
		Person person2 = new Person(); // 참조 변수 만들기 + 인스턴스 만들기 결합
		
		person2.name = "Jane Doe";
		person2.phone = "010-1234-5678";
		person2.email = "janedoe@example.com";
		
		personInfo = person2.info();
		System.out.println(personInfo);
		

	}

}
