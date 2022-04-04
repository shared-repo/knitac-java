
public class Ex02VariablesAndTypes {

	public static void main(String[] args) {
		
		//1. 변수 만들기 ( 이름, 자료형 )
		int age; // int : 정수, 4byte
		String name; // String : 문자열형
		
		//2. 변수 사용 : 변수에 데이터 저장
		age = 35;
		name = "John Doe";
		
		//3. 변수 사용 : 변수의 데이터 읽기
		System.out.println("Name : " + name + " / Age : " + age);
		
		//4. 변수 사용 : 연산
		age = age + 1;
		System.out.println("Name : " + name + " / Age : " + age);
		
		//5. 변수 초기화 : 변수 선언 + 값 저장
		int height = 180;
		System.out.println("Height : " + height);
	}

}
